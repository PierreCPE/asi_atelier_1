FROM openjdk:20
RUN mkdir -p /app/SP
WORKDIR /app/SP
COPY ./target/MicroServiceAuth-0.0.1-SNAPSHOT.jar MicroServiceAuth-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "MicroServiceAuth-0.0.1-SNAPSHOT.jar"]