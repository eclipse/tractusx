#
# Copyright (c) 2021 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

# Docker buildfile to containerize the dataspace connector (even when you are behind a corporate proxy) 
# such that it can be adapted/configured flexibly for concrete services
 
# Build the jar
FROM maven:3.8-jdk-11 AS maven

ARG MAVEN_OPTS ""

COPY pom.xml /tmp/

WORKDIR tmp

RUN mvn verify clean --fail-never

COPY src /tmp/src/

RUN mvn clean package -DskipTests -Dmaven.javadoc.skip=true

# Copy the jar and build image
FROM openjdk:11

COPY --from=maven --chown=65532:65532 /tmp/target/*.jar /app/app.jar

# These are the configuration properties to overwrite in order to configure the connector
ENV CONFIGURATION_PATH ""
ENV SPRING_JPA_DATABASE-PLATFORM ""
ENV SPRING_DATASOURCE_DRIVER-CLASS-NAME ""
ENV SPRING_DATASOURCE_PLATFORM ""
ENV SPRING_DATASOURCE_PASSWORD ""
ENV SPRING_DATASOURCE_USERNAME ""
ENV SPRING_DATASOURCE_URL ""
ENV CONFIGURATION_KEYSTOREPASSWORD ""
ENV CONFIGURATION_TRUSTSTOREPASSWORD ""

WORKDIR /app

EXPOSE 8080

#USER nonroot

ENTRYPOINT ["java","-jar","app.jar"]
