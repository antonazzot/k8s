FROM maven:3.8.5-openjdk-17-slim AS build

ADD ./pom.xml pom.xml
ADD ./src src/

RUN mvn clean package

FROM openjdk:17-alpine
COPY --from=build target/UserService-0.0.1-SNAPSHOT.jar application.jar

EXPOSE 7777

CMD java -jar application.jar
