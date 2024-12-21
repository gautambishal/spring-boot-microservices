FROM openjdk:17-ea-4-jdk-slim
VOLUME /app/log
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
EXPOSE 50621
ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]