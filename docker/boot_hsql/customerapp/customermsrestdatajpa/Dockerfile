FROM openjdk:11


# Copy the jar to the production image from the builder stage.
COPY  target/customermsrestdatajpa-*.war /demo.war

# expose container port for outer world
EXPOSE 8585

# Run the web service on container startup.
CMD java  -jar /demo.war
