FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/AerolineaModels-0.0.1-SNAPSHOT.jar  /app/AerolineaModels.jar

EXPOSE 9292

ENTRYPOINT ["java", "-jar", "/app/AerolineaModels.jar"]


