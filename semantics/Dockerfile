#
# Copyright (c) 2021 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

# Docker buildfile to containerize the semantics layer
 
# Compile/Build the jar
FROM maven:3-jdk-11 AS maven

ARG MAVEN_OPTS ""

WORKDIR /app

COPY . .

RUN mvn clean install -Dmaven.javadoc.skip=true -DskipTests -q

# Deploy the service
FROM openjdk:11-jre-buster

ARG HTTP_PROXY ""

RUN if [[ -n "${HTTP_PROXY}"  ]]; then echo "Acquire::http::Proxy \"${HTTP_PROXY}\"" >> /etc/apt/apt.conf.d/proxy.conf; fi
RUN if [[ -n "${HTTP_PROXY}" ]]; then echo "Acquire::https::Proxy \"${HTTP_PROXY}\"" >> /etc/apt/apt.conf.d/proxy.conf; fi

RUN apt-get -y upgrade
RUN apt-get -y update
RUN apt-get -y install graphviz
RUN adduser --system --group spring

RUN mkdir -p /semantics

RUN chown spring:spring /semantics

USER spring:spring

WORKDIR /semantics

RUN mkdir persistence

COPY --from=maven /app/target/semantics*.jar app.jar

ENV SERVER_PORT 4242
ENV SPRING_DATASOURCE_URL "jdbc:h2:file:/semantics/persistence"
ENV SPRING_DATASOURCE_DRIVERCLASSNAME "org.h2.Driver"
ENV SPRING_DATASOURCE_USERNAME "sa"
ENV SPRING_DATASOURCE_PASSWORD "password"
ENV IDSADAPTER_CONNECTORURL "http://localhost:8080"
ENV IDSADAPTER_SERVICEURL "http://localhost:4242"
ENV IDSADAPTER_PORTALURL "http://localhost:3000"
ENV SPRING_SQL_INIT_PLATFORM "h2"
ENV SPRING_JPA_HIBERNATE_DDL-AUTO "update"
ENV IDSADAPTER_CONNECTORUSER "admin"
ENV IDSADAPTER_CONNECTORPASSWORD "password"

EXPOSE 4242

ENTRYPOINT [ "java","-Dspring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL-AUTO}","-Dspring.sql.init.platform=${SPRING_SQL_INIT_PLATFORM}","-Didsadapter.portalUrl=${IDSADAPTER_PORTALURL}","-Didsadapter.serviceUrl=${IDSADAPTER_SERVICEURL}", "-Didsadapter.connectorUrl=${IDSADAPTER_CONNECTORURL}", "-Didsadapter.connectorUser=${IDSADAPTER_CONNECTORUSER}", "-Didsadapter.connectorPassword=${IDSADAPTER_CONNECTORPASSWORD}" ,"-Dspring.datasource.url=${SPRING_DATASOURCE_URL}","-Dspring.datasource.driverClassName=${SPRING_DATASOURCE_DRIVERCLASSNAME}","-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}","-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}","-jar","/semantics/app.jar" ]
