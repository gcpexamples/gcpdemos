FROM maven:3.8-jdk-11 as builder
FROM openjdk:11

# Copy local code to the container image.
WORKDIR /app
RUN mvn package -DskipTests=true
COPY target/projectsms-*.war  /projectsms.war

EXPOSE 8586

# Run the web service on container startup.
CMD java  -jar /projectsms.war

