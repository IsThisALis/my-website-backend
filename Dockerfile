FROM gradle:8-jdk21 AS build
WORKDIR /app

COPY build.gradle settings.gradle* ./
RUN gradle wrapper

COPY src ./src 

# === ДИАГНОСТИКА: Что именно видит Docker? ===
RUN echo "=== 1. ВСЕ JAVA ФАЙЛЫ В КОНТЕЙНЕРЕ ===" && find /app/src -name "*.java" || echo "JAVA ФАЙЛЫ НЕ НАЙДЕНЫ"
RUN echo "=== 2. СОДЕРЖИМОЕ Website.java (первые 5 строк) ===" && cat /app/src/main/java/com/isthisalis/website/Website.java | head -n 5 || echo "ФАЙЛ ПО ЭТОМУ ПУТИ ОТСУТСТВУЕТ"

RUN ./gradlew clean bootJar

RUN echo "=== 3. ВСЕ ФАЙЛЫ СО СЛОВОМ 'website' ВНУТРИ JAR ===" && jar tf /app/build/libs/*.jar | grep -i "website" || echo "НИЧЕГО НЕ НАЙДЕНО"

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app 
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
