
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY .mvn ./.mvn

RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar clinica-api-gns.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "clinica-api-gns.jar"]