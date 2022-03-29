#
# Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

# Docker buildfile to containerize the semantics layer
FROM openjdk:11-jre-buster

ARG HTTP_PROXY=""
RUN if [[ -n "${HTTP_PROXY}"  ]]; then echo "Acquire::http::Proxy \"${HTTP_PROXY}\"" >> /etc/apt/apt.conf.d/proxy.conf; fi
RUN if [[ -n "${HTTP_PROXY}" ]]; then echo "Acquire::https::Proxy \"${HTTP_PROXY}\"" >> /etc/apt/apt.conf.d/proxy.conf; fi

RUN apt-get -y upgrade
RUN apt-get -y update
RUN apt-get -y install graphviz

RUN if [[ -n "${HTTP_PROXY}"  ]]; then rm -f /etc/apt/apt.conf.d/proxy.conf; fi

RUN adduser --system --group spring

RUN mkdir -p /services

RUN chown spring:spring /services

USER spring:spring

WORKDIR /services

RUN mkdir persistence

COPY ./registry/target/registry*.jar app.jar

ENV SERVER_PORT 4242
ENV SPRING_DATASOURCE_URL "jdbc:h2:file:/services/persistence/persistence"
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
ENV IDP_ISSUER_URI "http://localhost:8080/auth/realms/catenax"
ENV JAVA_TOOL_OPTIONS "-Xms512m -Xmx2048m"

EXPOSE 4242

ENTRYPOINT [ "java","-Dspring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL-AUTO}","-Dspring.sql.init.platform=${SPRING_SQL_INIT_PLATFORM}","-Didsadapter.portalUrl=${IDSADAPTER_PORTALURL}","-Didsadapter.serviceUrl=${IDSADAPTER_SERVICEURL}", "-Didsadapter.connectorUrl=${IDSADAPTER_CONNECTORURL}", "-Didsadapter.connectorUser=${IDSADAPTER_CONNECTORUSER}", "-Didsadapter.connectorPassword=${IDSADAPTER_CONNECTORPASSWORD}" ,"-Dspring.datasource.url=${SPRING_DATASOURCE_URL}","-Dspring.datasource.driverClassName=${SPRING_DATASOURCE_DRIVERCLASSNAME}","-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}","-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}","-Dspring.security.oauth2.resourceserver.jwt.issuer-uri=${IDP_ISSUER_URI}","-jar","/services/app.jar" ]
