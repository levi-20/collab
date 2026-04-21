FROM maven:3.9.14-eclipse-temurin-25-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY .mvn ./.mvn
COPY mvnw .
COPY src ./src

RUN chmod +x mvnw && ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre-ubi10-minimal
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]