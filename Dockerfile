# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
#RUN apk add --no-cache bash
EXPOSE 8080
EXPOSE 8443
ENV Dspring.profiles.active=prod
VOLUME /tmp
ARG JAR_FILE
COPY keystore.p12 keystore.p12
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1