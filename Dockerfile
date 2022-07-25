FROM openjdk:8-jre-alpine

RUN mkdir /tmp/data

RUN mkdir /data

VOLUME /data

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} siret.jar

ENTRYPOINT ["java","-jar","/siret.jar", "--server.port=8080"]