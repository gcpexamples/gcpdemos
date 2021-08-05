FROM maven:3.8-jdk-11 as builder


# Copy local code to the container image.
WORKDIR /app
RUN mvn package -DskipTests=true
COPY target/projectsms-*.war  /projectsms.war

EXPOSE 8586
FROM openjdk:11
# Run the web service on container startup.
CMD java  -jar /projectsms.war

