FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} stock.jar
ENTRYPOINT ["java","-jar","/stock.jar"]