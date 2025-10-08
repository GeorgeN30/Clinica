
FROM maven:3.9.11-eclipse-temurin-21 AS build

WORKDIR /app
COPY clinica/pom.xml .

COPY clinica/src ./src
COPY clinica/.mvn ./.mvn

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]