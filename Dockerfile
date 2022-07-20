FROM openjdk:8-jre-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} siret.jar

ENTRYPOINT ["java","-jar","/siret.jar", "--server.port=8080"]