FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/GAI_Notifications-0.0.1-SNAPSHOT.jar /app/GAI_Notifications.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "GAI_Notifications.jar"]