# Step 1: Build the app
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app

# Copy project files into the container
COPY . .

# Give execute permission to mvnw before running it
RUN chmod +x mvnw

# Build the project without running tests
RUN ./mvnw clean package -DskipTests

# Step 2: Run the app
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the app port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
