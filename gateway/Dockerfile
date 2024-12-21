FROM openjdk:17-ea-4-jdk-slim
VOLUME /app/log
ADD target/gateway-service-0.0.1-SNAPSHOT.jar gateway-service-0.0.1-SNAPSHOT.jar
EXPOSE 58683
ENTRYPOINT ["java", "-jar", "gateway-service-0.0.1-SNAPSHOT.jar"]