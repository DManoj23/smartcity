# Step 1: Use an official lightweight Java 17 runtime image
FROM eclipse-temurin:17-jdk-jammy

# Step 2: Create a writable directory
VOLUME /tmp

# Step 3: Copy the built jar file from Maven target folder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Step 4: Expose Spring Boot default port
EXPOSE 8081

# Step 5: Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
