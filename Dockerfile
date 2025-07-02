# Imagen base con Java 21 (más liviana que openjdk)
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar solo los archivos necesarios para el build (si usas mvnw)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copiar todo el código fuente
COPY src src

# Dar permiso de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Construir el proyecto (sin tests)
RUN ./mvnw clean package -DskipTests

# Puerto que expondrá la app
EXPOSE 8080

# Ejecutar el jar empaquetado (ajusta el nombre si cambia)
CMD ["sh", "-c", "java -jar target/hexagonal-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}"]
