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

RUN adduser --system --group spring \
    && mkdir -p /service \
    && chown spring:spring /service

USER spring:spring

WORKDIR /service

COPY ./target/registry*.jar app.jar

ENV JAVA_TOOL_OPTIONS "-Xms512m -Xmx2048m"
EXPOSE 4243

ENTRYPOINT [ "java","-jar","/service/app.jar" ]
