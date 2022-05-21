FROM adoptopenjdk/openjdk11:alpine

WORKDIR /vinod

COPY target/hello-world-0.0.1-SNAPSHOT.jar ./app.jar

CMD ["java", "-jar", "app.jar"]

EXPOSE 8080