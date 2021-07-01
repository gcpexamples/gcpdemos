FROM maven:3.8-jdk-11 as builder

 # Copy local code to the container image.
WORKDIR /app

COPY pom.xml  .
COPY src    ./src

# Build a release artifact.
RUN mvn package -DskipTests=true

FROM openjdk:11


COPY --from=builder /app/target/greetingclient-*.war  /greetingclient.war

# Run the web service on container startup.
CMD java  -jar /greetingclient.war

