#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#EXPOSE 8080
#ARG JAR_FILE=target/spring-oauth-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#FROM java:8
#VOLUME /tmp
#EXPOSE 8080
#ADD target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]

#FROM openjdk:8-jdk-alpine
FROM java:8
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/spring-oauth-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]