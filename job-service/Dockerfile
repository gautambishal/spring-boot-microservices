FROM openjdk:17-ea-4-jdk-slim
VOLUME /app/log
ADD target/job-service-0.0.1-SNAPSHOT.jar job-service-0.0.1-SNAPSHOT.jar
EXPOSE 50650
ENTRYPOINT ["java", "-jar", "job-service-0.0.1-SNAPSHOT.jar"]