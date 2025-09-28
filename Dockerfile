# Use Eclipse Temurin JDK 21 as base image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot jar built by Maven
COPY target/app.jar app.jar

# Copy the OpenTelemetry agent
COPY target/agent/opentelemetry-javaagent.jar agent/opentelemetry-javaagent.jar

# Expose Spring Boot app port
EXPOSE 8080

# Run the app with OpenTelemetry agent attached
ENTRYPOINT ["java", "-javaagent:/app/agent/opentelemetry-javaagent.jar", "-jar", "/app/app.jar"]
