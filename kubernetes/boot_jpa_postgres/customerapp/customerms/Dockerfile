FROM openjdk:8


# Copy the jar to the production image from the builder stage.
COPY  target/customerms-*.war /demo.war

# Run the web service on container startup.
CMD java  -jar /demo.war
