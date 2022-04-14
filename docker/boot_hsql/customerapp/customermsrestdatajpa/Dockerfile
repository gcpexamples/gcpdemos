FROM openjdk:11


# Copy the jar to the production image from the builder stage.
COPY  build/libs/customermsrestdatajpa-*.war /demo.war


# Run the web service on container startup.
CMD java  -jar /demo.war
