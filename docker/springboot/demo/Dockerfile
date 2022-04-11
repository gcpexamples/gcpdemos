FROM openjdk:11


# Copy the jar to the production image from the builder stage.
COPY  build/libs/demo-*.jar /demo.jar


# Run the web service on cjntainer startup.
CMD java  -jar /demo.jar



