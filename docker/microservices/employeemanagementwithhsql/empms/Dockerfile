FROM openjdk:18.0.2-jdk


# Copy the jar to the production image from the builder stage.
COPY  target/empms-*.war /demo.war

EXPOSE 8587
# Run the web service on container startup.
CMD java  -jar /demo.war
