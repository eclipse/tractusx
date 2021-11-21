# Dependencies
FROM maven:3-jdk-11 AS maven
ARG BUILD_TARGET=prs-api
ARG PRS_EDC_PKG_USERNAME
ARG PRS_EDC_PKG_PASSWORD

WORKDIR /build

COPY ci ci
COPY api api
COPY .mvn .mvn
COPY settings.xml .
COPY pom.xml .

COPY broker-proxy-integration-tests broker-proxy-integration-tests
COPY broker-proxy broker-proxy
COPY connector/pom.xml connector/pom.xml
COPY connector/edc-patched-core connector/edc-patched-core
COPY connector/prs-connector-commons connector/prs-connector-commons
COPY connector/prs-connector-consumer connector/prs-connector-consumer
COPY connector/prs-connector-models connector/prs-connector-models
COPY connector/prs-connector-parent connector/prs-connector-parent
COPY connector/prs-connector-provider connector/prs-connector-provider
COPY connector/prs-connector-testing connector/prs-connector-testing
COPY integration-tests integration-tests
COPY prs-api prs-api
COPY prs-client prs-client
COPY prs-common prs-common
COPY prs-composite-client prs-composite-client
COPY prs-models prs-models
COPY prs-parent prs-parent
COPY prs-parent-spring-boot prs-parent-spring-boot
COPY prs-testing prs-testing

# the --mount option requires BuildKit.
RUN --mount=type=cache,target=/root/.m2 mvn -B -s settings.xml clean package -pl :$BUILD_TARGET -am -DskipTests

# Download Application Insights agent
FROM maven:3-jdk-11 AS wget

# Java app insight agent version: https://docs.microsoft.com/en-us/azure/azure-monitor/app/java-in-process-agent
# See https://confluence.catena-x.net/display/CXM/PRS+Observability
ARG appInsightsAgentVersion="3.1.1"
ARG appInsightsAgentURL="https://github.com/microsoft/ApplicationInsights-Java/releases/download/${appInsightsAgentVersion}/applicationinsights-agent-${appInsightsAgentVersion}.jar"

# jmx exporter version: https://github.com/prometheus/jmx_exporter/releases
ARG jmxPrometheusAgentVersion="0.16.1"
ARG jmxPrometheusAgentURL="https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/${jmxPrometheusAgentVersion}/jmx_prometheus_javaagent-${jmxPrometheusAgentVersion}.jar"

# Download app insights agent
RUN wget -q -O applicationinsights-agent.jar $appInsightsAgentURL
# Download jmx exporter agent (for non-spring boot applications)
RUN wget -q -O jmx-prometheus-agent.jar $jmxPrometheusAgentURL

# Copy the jar and build image
FROM adoptopenjdk:11-jre-hotspot AS runtime

WORKDIR /app

COPY --from=wget applicationinsights-agent.jar .
COPY cd/applicationinsights.json .

ENTRYPOINT ["java", "-javaagent:./applicationinsights-agent.jar", "-jar", "app.jar"]

FROM runtime AS broker-proxy
COPY --from=maven /build/broker-proxy/target/broker-proxy-*-exec.jar app.jar

FROM runtime AS prs-api
COPY --from=maven /build/prs-api/target/prs-api-*-exec.jar app.jar

FROM runtime AS prs-connector-provider
COPY --from=maven /build/connector/prs-connector-provider/target/prs-connector-provider-*.jar app.jar
COPY --from=maven /build/connector/prs-connector-provider/src/main/resources/logging.properties .
COPY --from=wget jmx-prometheus-agent.jar .
COPY cd/jmx_prometheus_config.yml .
ENTRYPOINT ["java", "-javaagent:./applicationinsights-agent.jar", "-javaagent:./jmx-prometheus-agent.jar=4006:./jmx_prometheus_config.yml", "-Djava.util.logging.config.file=./logging.properties", "-jar", "app.jar"]

FROM runtime AS prs-connector-consumer
COPY --from=maven /build/connector/prs-connector-consumer/target/prs-connector-consumer-*.jar app.jar
COPY --from=maven /build/connector/prs-connector-consumer/src/main/resources/logging.properties .
COPY --from=wget jmx-prometheus-agent.jar .
COPY cd/jmx_prometheus_config.yml .
ENTRYPOINT ["java", "-javaagent:./applicationinsights-agent.jar", "-javaagent:./jmx-prometheus-agent.jar=4006:./jmx_prometheus_config.yml", "-Djava.util.logging.config.file=./logging.properties", "-jar", "app.jar"]
