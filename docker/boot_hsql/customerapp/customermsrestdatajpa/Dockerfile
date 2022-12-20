FROM maven:3-openjdk-18
# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package
# Copy the jar to the production image from the builder stage.

FROM openjdk:18-oraclelinux7
COPY target/customermsrestdatajpa-*.war /demo.war

#expose port in container for traffic from outer world
EXPOSE 8484
CMD java -jar /demo.war
