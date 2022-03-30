FROM openjdk:11-jre-slim-buster
ARG JAR
ARG HTTP_PROXY

ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8090
ENV SPRING_PROFILES_ACTIVE local,basic
ENV IDSADAPTER_SERVICEURL http://registry-service:4243
ENV IDSADAPTER_CONNECTORTYPE edc
ENV IDSADAPTER_CONNECTORPROTOCOL http
ENV IDSADAPTER_CONNECTORHOST provider-control-plane:9191
ENV IDSADAPTER_CONNECTORURL http://provider-control-plane:9191
ENV IDSADAPTER_CONNECTORUSER X-Api-Key
ENV IDSADAPTER_CONNECTORPASSWORD 123456
ENV AASPROXY_REGISTRYURL http://registry-service:4243
ENV IDSADAPTER_ADAPTERURL http://provider-aas-service:4244
ENV AASPROXY_WRAPPERURL http://api-wrapper:9191/api/service

RUN if [[ -n "${HTTP_PROXY}"  ]]; then echo "Acquire::http::Proxy \"${HTTP_PROXY}\"" >> /etc/apt/apt.conf.d/proxy.conf; fi && \
    if [[ -n "${HTTP_PROXY}" ]]; then echo "Acquire::https::Proxy \"${HTTP_PROXY}\"" >> /etc/apt/apt.conf.d/proxy.conf; fi && \
    apt-get -y upgrade && \
    apt-get -y update && \
    apt-get -y install curl && \
    if [[ -n "${HTTP_PROXY}"  ]]; then rm -f /etc/apt/apt.conf.d/proxy.conf; fi

WORKDIR /app
COPY $JAR app.jar

EXPOSE 9191
EXPOSE 8090

ENTRYPOINT java \
    -Didsadapter.serviceUrl=${IDSADAPTER_SERVICEURL}\
    -Didsadapter.connectorType=${IDSADAPTER_CONNECTORTYPE}\
    -Didsadapter.connectorProtocol=${IDSADAPTER_CONNECTORPROTOCOL}\
    -Didsadapter.connectorHost=${IDSADAPTER_CONNECTORHOST}\
    -Didsadapter.connectorUrl=${IDSADAPTER_CONNECTORURL}\
    -Didsadapter.connectorUser=${IDSADAPTER_CONNECTORUSER}\
    -Didsadapter.connectorPassword=${IDSADAPTER_CONNECTORPASSWORD}\
    -Didsadapter.adapterUrl=${IDSADAPTER_ADAPTERURL}\
    -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}\
    -Daasproxy.registryUrl=${AASPROXY_REGISTRYURL}\
    -Daasproxy.wrapperUrl=${AASPROXY_WRAPPERURL}\
    -Djava.security.edg=file:/dev/.urandom \
    -Dedc.fs.config="configuration.properties"\
    -jar app.jar
