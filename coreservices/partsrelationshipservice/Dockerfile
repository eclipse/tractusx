# Dependencies
FROM maven:3-jdk-11 AS maven
WORKDIR /build
COPY pom.xml .
COPY integration-tests integration-tests
COPY prs-api prs-api
COPY prs-models prs-models
COPY prs-parent prs-parent
COPY prs-testing prs-testing
COPY ci ci
# the --mount option requires BuildKit.
RUN --mount=type=cache,target=/root/.m2 mvn -B clean package -DskipTests

# Copy the jar and build image
FROM openjdk:11-jdk AS runtime
# Java app insight agent version: https://docs.microsoft.com/en-us/azure/azure-monitor/app/java-in-process-agent
# See https://confluence.catena-x.net/display/CXM/PRS+Observability
ARG appInsightsAgentVersion="3.1.1"
ARG appInsightsAgentURL="https://github.com/microsoft/ApplicationInsights-Java/releases/download/${appInsightsAgentVersion}/applicationinsights-agent-${appInsightsAgentVersion}.jar"

WORKDIR /app
RUN wget -q -O applicationinsights-agent.jar $appInsightsAgentURL
COPY cd/applicationinsights.json .

EXPOSE 8080
ENTRYPOINT ["java", "-javaagent:./applicationinsights-agent.jar", "-jar", "app.jar"]

FROM runtime AS prs
COPY --from=maven /build/prs-api/target/prs-*-exec.jar app.jar
