FROM openjdk:11-jre-slim
RUN apt-get update
RUN apt-get -y install graphviz
RUN adduser --system --group spring
RUN mkdir -p /semantics
RUN chown spring:spring /semantics
USER spring:spring
WORKDIR /semantics
RUN mkdir persistence
ARG JAR_FILE=target/semantics*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.jpa.hibernate.ddl-auto=update","-Dspring.datasource.url=${SPRING_DATASOURCE_URL}","-Dspring.datasource.driverClassName=${SPRING_DATASOURCE_DRIVERCLASSNAME}","-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}","-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}","/semantics/app.jar"]