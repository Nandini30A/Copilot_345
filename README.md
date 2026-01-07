# Random Number Generator (Java Spring Boot)

This is a minimal Java Spring Boot application that exposes a simple random number generator endpoint.

Quick start:

1. Clone the repository:

   git clone https://github.com/Nandini30A/Copilot_345.git
   cd Copilot_345

2. Build and run using Maven (you need Java 17+ and Maven installed):

   mvn spring-boot:run

   or build and run the jar:

   mvn -DskipTests package
   java -jar target/randomnum-0.0.1-SNAPSHOT.jar

3. Open in your browser:

   http://localhost:8080/

API endpoint:

- GET /api/random?min=1&max=10  -> returns JSON like {"value":7,"min":1,"max":10}

Notes:

- Default range is min=0 and max=100.
- If min > max, the server swaps them.
