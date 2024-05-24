FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/music-service-0.0.1-SNAPSHOT.jar music-service.jar
CMD ["java", "-jar", "music-service.jar"]