# Imagen base con Java 21 (Eclipse Temurin)
FROM eclipse-temurin:21-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar solo los archivos necesarios para construir (optimiza caché)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Dar permisos al wrapper de Maven
RUN chmod +x mvnw

# Instalar dependencias y compilar sin tests
RUN ./mvnw clean package -DskipTests

# Copiar el código fuente (si lo necesitas para algo más, sino ya está en el build)
COPY src ./src

# Exponer puerto de la aplicación
EXPOSE 8080

# Ejecutar el JAR generado (ajusta el nombre si es otro)
CMD ["java", "-jar", "target/api-0.0.1-SNAPSHOT.jar", "--server.port=8080"]
