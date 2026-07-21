FROM gradle:8-jdk21 AS build
WORKDIR /app

# Копируем оба файла конфигурации, если settings.gradle есть
COPY build.gradle settings.gradle* ./
RUN gradle wrapper

# Копируем исходники ДО сборки
COPY src ./src 

# ОБЯЗАТЕЛЬНО clean, чтобы убить любой кэш Gradle, и bootJar для гарантированного fat-jar
RUN ./gradlew clean bootJar

# === ЖЕСТКАЯ ПРОВЕРКА 1: Если класса нет в собранном jar, сборка УПАДЕТ здесь ===
RUN echo "=== ПРОВЕРКА СОДЕРЖИМОГО JAR НА ЭТАПЕ СБОРКИ ===" && \
    ls -la /app/build/libs/ && \
    jar tf /app/build/libs/*.jar | grep "BOOT-INF/classes/com/isthisalis/website/Website.class" || \
    (echo "!!! ОШИБКА: Website.class НЕ НАЙДЕН В JAR ФАЙЛЕ НА ЭТАПЕ СБОРКИ !!!" && exit 1)

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app 

# Копируем jar
COPY --from=build /app/build/libs/*.jar app.jar

# === ЖЕСТКАЯ ПРОВЕРКА 2: Проверяем, что именно попало в финальный образ ===
RUN echo "=== ПРОВЕРКА СОДЕРЖИМОГО JAR В ФИНАЛЬНОМ ОБРАЗЕ ===" && \
    jar tf app.jar | grep "BOOT-INF/classes/com/isthisalis/website/Website.class" || \
    (echo "!!! ОШИБКА: Website.class НЕ ПОПАЛ В ФИНАЛЬНЫЙ app.jar !!!" && exit 1)

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
