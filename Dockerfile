FROM openjdk:17-jdk-slim as build

WORKDIR /app

COPY build/libs/balkan-travel-thesis-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080