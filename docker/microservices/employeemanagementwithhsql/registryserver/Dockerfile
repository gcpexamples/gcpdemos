FROM maven:3.8-jdk-11 as builder
FROM openjdk:11

# Copy local code to the container image.
WORKDIR /app

RUN mvn package -DskipTests=true

COPY target/registryserver-*.war /registry.war

EXPOSE 8761
# Run the web service on container startup.
 CMD java  -jar /registry.war

