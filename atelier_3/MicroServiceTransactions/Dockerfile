# Utiliser une image de base avec Maven pour construire l'application
FROM maven:3.8.4-openjdk-11-slim AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier pom.xml pour installer les dépendances
COPY pom.xml .

# Copier les sources
COPY src ./src

# Compiler l'application
RUN mvn clean package -DskipTests

# Utiliser une image plus légère avec Java pour exécuter l'application
FROM adoptopenjdk:11-jre-hotspot

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR de construction depuis l'étape précédente
COPY --from=build /app/target/microservice-transactions.jar app.jar

# Exposer le port sur lequel l'application écoute (ajuster si nécessaire)
EXPOSE 8080

# Lancer l'application Spring Boot
CMD ["java", "-jar", "app.jar"]
