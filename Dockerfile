# Build stage
FROM maven:3.6.3-openjdk-8 AS build

COPY spring-app/src /usr/src/app/src
COPY spring-app/pom.xml /usr/src/app/

RUN mvn -f /usr/src/app/pom.xml clean package

# Package stage
FROM openjdk:8-jdk-alpine

ARG PROP_FILE=application.properties

WORKDIR /usr/local/test-app

COPY --from=build /usr/src/app/target/spring-test-for-docker-1.0-SNAPSHOT.jar app.jar
COPY ${PROP_FILE} application.properties

CMD ["java", "-jar", "app.jar", "--spring.config.location=/usr/local/test-app/application.properties"]
