# Use official Eclipse Temurin (Java 17) image with Maven installed
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper files first to leverage Docker cache
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies (to use cache if pom hasn't changed)
RUN ./mvnw dependency:go-offline

# Copy the rest of the app
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the JAR file (replace with your actual jar name if different)
CMD ["java", "-jar", "target/challenge-0.0.1-SNAPSHOT.jar"]