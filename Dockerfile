# Use Eclipse Temurin JDK 21 as base image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built jar into the container
COPY target/opentel-0.0.1-SNAPSHOT.jar app.jar

# Download the latest OpenTelemetry Java Agent
#RUN curl -L -o opentelemetry-javaagent.jar \
#    https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

ADD target/agent/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar


# Expose Spring Boot app port
EXPOSE 8080

# Run the app with OpenTelemetry agent
ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar","-Dotel.traces.exporter=logging","-Dotel.metrics.exporter=logging", "-Dotel.logs.exporter=logging", "-jar", "app.jar"]
