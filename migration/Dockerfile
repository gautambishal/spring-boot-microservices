FROM openjdk:17-ea-4-jdk-slim
VOLUME /app/log
ADD target/migration-0.0.1-SNAPSHOT.jar migration-0.0.1-SNAPSHOT.jar
EXPOSE 56666
ENTRYPOINT ["java", "-jar", "migration-service-0.0.1-SNAPSHOT.jar"]