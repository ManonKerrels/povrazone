FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} order.jar
ENTRYPOINT ["java","-jar","/order.jar"]