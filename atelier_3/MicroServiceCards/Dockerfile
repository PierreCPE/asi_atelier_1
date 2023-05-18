FROM openjdk:20
RUN mkdir -p /app/SP
WORKDIR /app/SP
COPY ./target/MicroServiceCards-0.0.1-SNAPSHOT.jar MicroServiceCards-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "MicroServiceCards-0.0.1-SNAPSHOT.jar"]