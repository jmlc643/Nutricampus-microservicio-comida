# Establece la imagen base de Gradle para la etapa de compilación
FROM gradle:jdk17 AS build

# Establece el directorio de trabajo dentro de la imagen
WORKDIR /app

# Copia los archivos de configuración de Gradle y las dependencias en caché
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle

# Descarga las dependencias
RUN gradle build -x test --no-daemon

# Copia el código fuente de la aplicación
COPY src ./src

# Compila la aplicación
RUN gradle build -x test --no-daemon

# Usa una imagen de Java para la etapa final
FROM openjdk:17

# Establece el directorio de trabajo dentro de la imagen
WORKDIR /app

# Copia el JAR compilado desde la etapa de construcción
COPY --from=build /app/build/libs/microservicio-dieta-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la aplicación
EXPOSE 8081

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
