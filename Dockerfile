FROM openjdk:17-oracle

WORKDIR /app

COPY target/userservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]