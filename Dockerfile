FROM openjdk:8-jdk-alpine
RUN addgroup -S demo && adduser -S esgodoroja -G demo
USER esgodoroja:demo
ADD build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080:8080
