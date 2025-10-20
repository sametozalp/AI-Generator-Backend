# 1️⃣ Build aşaması
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app

# pom.xml ve kaynak kodu kopyala
COPY pom.xml .
COPY src ./src

# JAR dosyasını oluştur
RUN mvn clean package -DskipTests

# 2️⃣ Runtime aşaması
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Build aşamasından jar'ı al
COPY --from=build /app/target/*.jar app.jar

# Uygulamanın dinlediği portu expose et
EXPOSE 8080

# Uygulama başlat
ENTRYPOINT ["java", "-jar", "app.jar"]
