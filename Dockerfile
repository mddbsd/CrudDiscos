FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/crudDiscos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_crudDiscos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_crudDiscos.jar"]
