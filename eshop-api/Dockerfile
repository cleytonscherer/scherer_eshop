#FROM openjdk:21-jdk as builder
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR application
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw package -DskipTests
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:21-jre-alpine
WORKDIR application
#COPY --from=builder /application/dependencies/ ./
#COPY --from=builder /application/spring-boot-loader/ ./
#COPY --from=builder /application/snapshot-dependencies/ ./
#COPY --from=builder /application/application/ ./
COPY --from=builder /application/target/*.jar application.jar
EXPOSE 8080
#ENTRYPOINT ["java", "org.springframework.boot.loader.lauch.JarLauncher"]
ENTRYPOINT ["java", "-jar", "application.jar"]

