# DOCKER FILE MULTISTAGE BUILD

# STAGE 1: Build
FROM maven:3.6.3-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the source code
COPY pom.xml .
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# STAGE 2: Run Zulu 17 from a smaller image size
FROM azul/zulu-openjdk:17.0.13-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]