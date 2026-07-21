FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY build.gradle .
RUN gradle wrapper
RUN ./gradlew dependencies
COPY src ./src 
RUN ./gradlew build

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app 
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT  ["sh", "-c", "java -jar app.jar --server.port=${port:-8080}"] 
