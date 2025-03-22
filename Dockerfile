# Use Maven with JDK 21 for building
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copy Maven files and download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build application without tests
RUN mvn clean package -DskipTests

# Use JRE for runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy built JAR
COPY --from=builder /app/target/*.jar lumi.jar

# Ensure JAR has executable permissions
RUN chmod +x lumi.jar

# Expose port (Fly.io will map to 8080 by default)
EXPOSE 8080

# Allow runtime Java options through JAVA_OPTS
ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/lumi.jar"]
