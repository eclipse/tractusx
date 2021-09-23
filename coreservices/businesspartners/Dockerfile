FROM mcr.microsoft.com/java/jdk:11-zulu-alpine

ENV TABLENAME BusinessPartners
ENV STORAGE_CONNECTIONSTRING UNKNOWN_STORAGE_CONNECTIONSTRING
ENV HTTPUSERNAME TractusX
ENV HTTPPASSWORD UNKNOWN_HTTPPASSWORD

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]