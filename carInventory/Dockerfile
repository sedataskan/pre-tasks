# Use the Maven image from the Docker Hub
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code to the working directory
COPY pom.xml ./
COPY src ./src

# Run Maven clean and install commands
RUN mvn clean install

# Use a smaller image to run the application
FROM openjdk:22
COPY --from=build /app/target/carInventory-0.0.1-SNAPSHOT.jar carInventory.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "carInventory.jar"]