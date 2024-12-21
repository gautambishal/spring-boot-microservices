FROM openjdk:17-ea-4-jdk-slim
VOLUME /app/log
ADD target/config-server-0.0.1-SNAPSHOT.jar config-server-0.0.1-SNAPSHOT.jar
EXPOSE 58683
ENTRYPOINT ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]