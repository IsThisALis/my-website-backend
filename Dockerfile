FROM gradle:8-jdk21 AS build
WORKDIR /app

# 1. Полностью изолируем кэш Gradle, чтобы исключить его влияние
ENV GRADLE_USER_HOME=/tmp/gradle

COPY build.gradle settings.gradle* ./
RUN gradle wrapper

COPY src ./src 

# 2. ПРОВЕРКА: Убеждаемся, что файлы на месте (для логов)
RUN ls -la /app/src/main/java/com/isthisalis/website/

# 3. ПРИНУДИТЕЛЬНОЕ УКАЗАНИЕ ИСХОДНИКОВ
# Добавляем в конец build.gradle, чтобы перебить любые скрытые настройки sourceSets
RUN echo "sourceSets { main { java { srcDirs = ['src/main/java'] } resources { srcDirs = ['src/main/resources'] } } }" >> build.gradle

# 4. СБОРКА С ПОЛНЫМ ЛОГОМ КОМПИЛЯЦИИ
# Если упадет, мы увидим точную причину в /tmp/build.log
RUN ./gradlew clean compileJava bootJar --info > /tmp/build.log 2>&1 || (cat /tmp/build.log && exit 1)

# 5. ФИНАЛЬНАЯ ПРОВЕРКА СОДЕРЖИМОГО JAR
RUN jar tf /app/build/libs/*.jar | grep "BOOT-INF/classes/com/isthisalis/website/Website.class" || (echo "!!! КЛАСС ВСЕ ЕЩЕ ОТСУТСТВУЕТ В JAR !!!" && cat /tmp/build.log && exit 1)

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app 
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
