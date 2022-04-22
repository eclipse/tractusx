#
# Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

FROM openjdk:11-jre-buster

RUN apt-get -y upgrade \
    && apt-get -y update \
    && apt-get -y install graphviz \
    && apt-get clean

RUN adduser --system --group spring \
    && mkdir -p /service \
    && chown spring:spring /service

USER spring:spring

WORKDIR /service

COPY ./target/semantic-hub*.jar app.jar

ENV JAVA_TOOL_OPTIONS "-Xms512m -Xmx2048m"

EXPOSE 4242

ENTRYPOINT [ "java","-jar","/service/app.jar" ]
