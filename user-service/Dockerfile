FROM openjdk:17-ea-4-jdk-slim
VOLUME /app/log
ADD target/auth-service-0.0.1-SNAPSHOT.jar auth-service-0.0.1-SNAPSHOT.jar
EXPOSE 58683
ENTRYPOINT ["java", "-jar", "auth-service-0.0.1-SNAPSHOT.jar"]