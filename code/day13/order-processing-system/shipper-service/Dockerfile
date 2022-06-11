FROM adoptopenjdk/openjdk11:alpine

WORKDIR /vinod

COPY target/shipper-service-0.0.1-SNAPSHOT.jar ./app.jar

CMD ["java", "-jar", "app.jar"]

EXPOSE 7001