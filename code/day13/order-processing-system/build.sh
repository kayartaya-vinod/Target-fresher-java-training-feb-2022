cd ./customer-service
mvn clean package -DskipTests
cd ../employee-service
mvn clean package -DskipTests
cd ../product-service
mvn clean package -DskipTests
cd ../shipper-service
mvn clean package -DskipTests
cd ../order-service
mvn clean package -DskipTests
cd ..

docker compose build