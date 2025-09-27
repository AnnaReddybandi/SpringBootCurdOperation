FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/TaskManagement-0.0.1-SNAPSHOT.jar app.jar   # <-- match your actual jar filename
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

