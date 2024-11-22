# SimpleURLShortener

This is a simple URL shortener service, created by using Spring Boot.

# Storage

All the URLs are stored inside a Redis database, which is hosted inside a docker container.

# Hashing

Java's Message Digest was used in order to hash the URL value with SHA-256 hashing algorithm

# How to test

1. Clone this project
2. When you are inside the project directory, you can run docker-compose up to start the Docker service
3. Then launch the Java project
4. Once you are ready and made sure both services are working you can use Postman to test the API

