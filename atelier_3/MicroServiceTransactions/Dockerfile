FROM openjdk:20
RUN mkdir -p /app/SP
WORKDIR /app/SP
COPY ./target/MicroServiceTransaction-0.0.1-SNAPSHOT.jar MicroServiceTransaction-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "MicroServiceTransaction-0.0.1-SNAPSHOT.jar"]