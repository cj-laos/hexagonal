# Imagen base con Java 17 (o la versión que uses)
FROM openjdk:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo jar generado por Maven/Gradle
COPY target/*.jar app.jar

# Expone el puerto donde corre tu Spring Boot (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
