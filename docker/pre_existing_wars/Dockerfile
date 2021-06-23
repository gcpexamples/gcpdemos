FROM openjdk:11

WORKDIR /app

COPY demo.war .


# expose container port for outer world
EXPOSE 8080

# Run the web service on container startup.
CMD java  -jar demo.war
