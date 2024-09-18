FROM eclipse-temurin:22-jdk

WORKDIR /app

COPY target/web_security-0.0.1-SNAPSHOT.jar /app/web_security.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/web_security.jar"]