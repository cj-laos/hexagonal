# Imagen base con Java 21 (más liviana que openjdk)
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Usar ENTRYPOINT para ejecutar el jar con puerto dinámico
ENTRYPOINT ["sh", "-c", "java -jar target/hexagonal-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}"]
