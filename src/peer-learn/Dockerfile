FROM amazoncorretto:18.0.1 as builder
WORKDIR /peerlearn
COPY . /peerlearn
RUN ["ls"]
RUN ["./gradlew","bootjar"]

FROM openjdk:18-jdk-slim
WORKDIR /peerlearn
COPY --from=builder /peerlearn/build/libs/peerlearn-0.0.1-SNAPSHOT.jar .
CMD [ "echo $DB_URL $DB_USER $DB_PASSWORD ; java -jar ./peerlearn-0.0.1-SNAPSHOT.jar"]