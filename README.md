# Refund Management System
Refund Management System is a backend application built using Java and Spring Boot to manage customer refunds efficiently with full CRUD (Create, Read, Update, Delete) functionality. It provides RESTful APIs for seamless integration with front-end or third-party systems.

## Table of Contents

- [Introduction](#Introduction)
- [Objective](#Objective)
- [Tools & Technologies](#Tools-&-Technologies)
- [Features](#Features)
- [Implementation Details](#Implementation-Details)
- [Screenshots and Workflow](#Screenshots-and-Workflow)
- [Conclusion](#Conclusion)

## Introduction
- In this project, I developed a Refund Management System backend application using Spring Boot.
- The system allows users (or admin interfaces) to manage refund records — creating, updating, deleting, and retrieving refund information stored in an Oracle Database.
- This project demonstrates backend development, REST API creation, validation, exception handling, and database persistence using Spring Data JPA.

## Objective
- Build a Spring Boot backend module to manage customer refunds.
- Implement RESTful API endpoints for CRUD operations.
- Integrate with Oracle Database for persistence using Spring Data JPA.
- Apply validation and exception handling for robust backend operation.
- Test all APIs using Postman for smooth client-server interaction.

## Tools & Technologies
- Language       : Java 17
- Framework      : Spring Boot 3.5
- Database       : Oracle Database
- ORM            : Spring Data JPA
- Validation     : Jakarta Validation API
- Testing        : Postman
- Build Tool     : Maven
- IDE            : Spring Tool Suite 4 / Eclipse
- Version Control: Git & GitHub

## Features
- Full CRUD operations on refund records.
- RESTful APIs using Spring Boot controllers.
- Validation on user input (e.g., non-null, positive IDs).
- Custom Exception Handling with detailed error responses.
- Timestamps for record creation and updates using JPA lifecycle callbacks.
- Logging for service operations using SLF4J.
- Tested APIs using Postman for verification.

## Implementation Details
### Entity Design
The main entity is **Refund**, which includes:
- refundId — Primary Key (Auto-generated)
- orderId — Reference to order
- userId — Reference to user
- createdTimestamp — Automatically added at creation
- updatedTimestamp — Automatically updated during modification

### Controller
Implements REST endpoints for:
- POST /api/refund → Create Refund
- GET /api/refund/{id} → Retrieve Refund by ID
- PUT /api/refund/{id} → Update Refund
- PATCH /api/refund/{id} → Partial Update
- DELETE /api/refund/{id} → Delete Refund
All endpoints return JSON responses and include exception handling for invalid or missing data.

### Service Layer
- Handles business logic for refunds.
- Performs validation checks and timestamp management.
- Uses RefundRepository (JPA) for data persistence.

### Exception Handling
Implemented GlobalExceptionHandler to handle:
- RefundNotFoundException for invalid IDs.
- MethodArgumentNotValidException for invalid input.
- Generic RuntimeException for unexpected errors.
This ensures consistent and clear API responses.

### Testing (Postman)
- CRUD operations function correctly.
- Validation and error responses display properly.

### Screenshots and Workflow
#### Workflow:
![](https://github.com/Sudharshan2024/Virtual-Art-Gallery/blob/24d4a947d0f76dacd63154d3afc349a9019d3a13/WorkFlow.jpg)
#### POST Request:
Creating a Refund
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Creating-A-refund.jpg)
#### GET Request:
Retrieving Refund by ID
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Retrieving-A-Refund.jpg)
#### PUT Request:
Updating Refund Data
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Updating-A-Refund.jpg)
#### PATCH request:
Partially Updating Refund Data
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Partiallly-Updating-A-Refund.jpg)
#### DELETE Request:
Removing Refund
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Removing-A-Refund.jpg)
#### Invalid GET request
Try to Create a Invalid refund for testing purpose
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Creating-A-Invalid-refund-ID.jpg)
#### Invalid DELETE Request:
Try to Remove a Non existing refund for testing purpose
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/Removing-A-Non-Existing-Refund-ID.jpg)
#### Refund-DataBase in the Oracle Developer
![](https://github.com/Sudharshan2024/Refund-Management-System/blob/main/Images/refund-Database.jpg)

## Conclusion
The Refund Management System project demonstrates backend development using Java, Spring Boot, and Oracle Database.
It successfully handles full refund lifecycle management, implements REST APIs, and ensures reliable validation and error handling.
