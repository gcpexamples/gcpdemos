FROM maven:3.8-jdk-11 as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

FROM openjdk:11

# Copy the jar to the production image from the builder stage.
COPY --from=builder /app/target/bootjpademo-*.war /bootjpademo.war

# Run the web service on container startup.
CMD java  -jar /bootjpademo.war