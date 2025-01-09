
# Order Processing System

This project is a **Spring Boot microservice** that implements an end-to-end non-blocking order processing system using **Kafka** for message communication and **MongoDB** for persistence. 

## Features
- Send and receive **order messages** via Kafka.
- Store processed orders in a **MongoDB** database.
- Fully asynchronous and scalable architecture.

---

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Data MongoDB**
- **Kafka**
- **MongoDB**
- **Gradle**

---

## Project Structure
```
📁 kafka-mtls-producer
   ┣ 📂 src/main/java/com/example/orderprocessing
   ┃ ┣ 📂 controller
   ┃ ┣ 📂 service
   ┃ ┣ 📂 model
   ┃ ┗ 📂 repository
   ┣ 📂 resources
   ┗ 📄 build.gradle
```

---

## Prerequisites
1. **Kafka broker** with SSL/TLS enabled.
2. **MongoDB** instance running locally or remotely.
3. **Java 17** installed.
4. **Gradle** installed.

---

## Setup and Configuration

### 1. Configure `application.yml`
Ensure the following properties are correctly set in `src/main/resources/application.yml`:
```yaml
spring:
  kafka:
    bootstrap-servers: <your-kafka-broker-url>
    ...
  data:
    mongodb:
      uri: mongodb://localhost:27017/ordersdb
```

---

## How to Run

### 1. Start Kafka and MongoDB
Ensure your **Kafka** broker and **MongoDB** instance are running.

### 2. Build and Run the Application
```bash
./gradlew bootRun
```

### 3. Test the Application
Send an order to Kafka using a REST API:
```bash
curl -X POST "http://localhost:8080/orders" -H "Content-Type: application/json" -d '{"orderDetails": "Sample Order"}'
```

---

## Endpoints

- **POST /orders**  
  Sends an order to Kafka:
  ```json
  {
    "orderDetails": "Sample Order"
  }
  ```

