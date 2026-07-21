FROM gradle:8-jdk21 AS build
WORKDIR /app

# Копируем ВСЁ содержимое проекта сразу, чтобы исключить рассинхрон
COPY . .

# 1. ДИАГНОСТИКА: Печатаем, какие папки Gradle считает исходными
RUN echo "=== GRADLE SOURCE SETS ===" && ./gradlew properties --no-daemon | grep -A 3 "srcDirs" || echo "Не удалось получить srcDirs"

# 2. ПРИНУДИТЕЛЬНОЕ ИСПРАВЛЕНИЕ: Добавляем в конец build.gradle явное указание путей
# Это перебивает любые сбои от плагинов или settings.gradle
RUN echo "" >> build.gradle && \
    echo "sourceSets { main { java { srcDirs = ['src/main/java'] } resources { srcDirs = ['src/main/resources'] } } }" >> build.gradle

# 3. СБОРКА
RUN ./gradlew clean compileJava bootJar --info > /tmp/build.log 2>&1 || (cat /tmp/build.log && exit 1)

# 4. ПРОВЕРКА
RUN echo "=== ПРОВЕРКА JAR ===" && jar tf /app/build/libs/*.jar | grep "BOOT-INF/classes/com/isthisalis/website/Website.class" || (echo "!!! КЛАСС НЕ НАЙДЕН !!!" && cat /tmp/build.log && exit 1)

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app 
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
