FROM openjdk:20
RUN mkdir -p /app/SP
WORKDIR /app/SP
COPY ./target/MicroServiceTransactions-0.0.1-SNAPSHOT.jar MicroServiceTransactions-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "MicroServiceTransactions-0.0.1-SNAPSHOT.jar"]