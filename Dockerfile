#FROM openjdk:17-jdk-slim as build

#WORKDIR /app

#COPY build/libs/balkan-travel-thesis-1.0.0.jar app.jar

#ENTRYPOINT ["java", "-jar", "/app/app.jar"]

#EXPOSE 8080

FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon -x test && cp build/libs/*.jar app.jar

FROM eclipse-temurin:17-jre
COPY --from=build /app/app.jar /app.jar
ENV JAVA_TOOL_OPTIONS="-Xmx350m"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]