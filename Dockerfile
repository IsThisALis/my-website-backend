# syntax=docker/dockerfile:1.7

FROM gradle:8-jdk21 AS build
WORKDIR /workspace

ENV GRADLE_USER_HOME=/home/gradle

COPY build.gradle* settings.gradle* gradlew ./
COPY gradle ./gradle

#RUN --mount=type=cache,target=/home/gradle \
#    chmod +x ./gradlew && ./gradlew --version

COPY src ./src

RUN --mount=type=cache,target=/home/gradle \
    gradle bootJar --no-daemon && \
    find build/libs -maxdepth 1 -name '*.jar' ! -name '*-plain.jar' -exec mv {} /workspace/app.jar \;

FROM ibm-semeru-runtimes:open-21-jre
WORKDIR /app

COPY --from=build /workspace/app.jar app.jar

RUN mkdir -p /app/class-cache && \
    java -Xshareclasses:name=springCache,cacheDir=/app/class-cache \
         -Dspring.profiles.active=cds \
         -Dspring.context.exit=onRefresh \
         -jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "exec java -Xshareclasses:name=springCache,cacheDir=/app/class-cache -jar /app/app.jar --server.port=${PORT:-8080}"]