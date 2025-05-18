FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests
CMD ["java", "-jar", "target/tfg-0.0.1-SNAPSHOT.war"]