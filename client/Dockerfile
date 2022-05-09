FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} client.jar
ENTRYPOINT ["java","-jar","/client.jar"]