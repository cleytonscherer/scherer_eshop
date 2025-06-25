FROM openjdk:21-jdk
VOLUME /eshop
ARG JAR_FILE=target/eshop-api-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
