FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/user-module-api.jar user-module-api.jar
ENTRYPOINT ["java","-jar","/user-module-api.jar"]