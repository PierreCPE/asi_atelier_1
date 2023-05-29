FROM openjdk:20
RUN mkdir -p /app/SP
WORKDIR /app/SP
COPY ./target/MicroServiceUsers-0.0.1-SNAPSHOT.jar MicroServiceUsers-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "MicroServiceUsers-0.0.1-SNAPSHOT.jar"]