FROM adoptopenjdk/openjdk11:alpine

WORKDIR /vinod

COPY ./target/eureka-discovery-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8761

ENTRYPOINT java -jar app.jar