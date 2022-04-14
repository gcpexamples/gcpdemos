FROM openjdk:11

# Copy local code to the container image.
#WORKDIR /app



COPY  build/libs/customermsrestdatajpa-*.war /demo.war



# Run the web service on container startup.
 CMD  java -jar /demo.war

