# Employee Management System

A Spring Boot based Employee Management System for managing employee information and providing REST APIs for employee operations.

## Features

- Employee registration and management
- Create, view, update and delete employees
- Employee details management
- OTP generation and verification
- RESTful APIs
- MySQL database integration
- Spring Data JPA and Hibernate
- Maven project

## Technologies

Java | Spring Boot | Spring Data JPA | Hibernate | MySQL | Maven | REST API

## Project Structure

`src/main/java` – Application source code  
`src/main/resources` – Application configuration and resources  
`src/test` – Test cases  
`pom.xml` – Maven dependencies and configuration

## Database

Create the MySQL database:

CREATE DATABASE employee_management_system;

Configure your database credentials in:

`src/main/resources/application.properties`

## Run the Application

Using Maven:

`mvn spring-boot:run`

On Windows:

`mvnw.cmd spring-boot:run`

The application runs by default at:

`http://localhost:8080`

## Testing

`mvn test`

## Build

`mvn clean package`

The generated JAR file will be available in the `target` folder.

## GitHub

https://github.com/abhi5016/Employee-Management-System

## Author

Abhishek

## License

This project is for learning and development purposes.
