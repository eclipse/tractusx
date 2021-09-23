FROM mcr.microsoft.com/java/jdk:11-zulu-alpine
RUN addgroup -S spring && adduser -S spring -G spring
RUN mkdir -p /semantics
RUN chown spring:spring /semantics
USER spring:spring
WORKDIR /semantics
RUN mkdir persistence
ARG JAR_FILE=target/semantics*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:h2:file:/semantics/persistence","-jar","/semantics/app.jar"]