# 💰 Expense Tracker – Spring Boot REST API

A backend application built using **Java and Spring Boot** to manage personal expenses through RESTful APIs. It provides secure user authentication, expense management, and efficient data retrieval using PostgreSQL.

## 🚀 Features

- **User Authentication:** JWT-based authentication and authorization.
- **Expense Management:** Create, retrieve, update, and delete expenses (CRUD operations).
- **Database Integration:** PostgreSQL for persistent data storage.
- **Expense Search:** Search expenses by title.
- **Category Filtering:** Filter expenses based on categories.
- **Pagination & Sorting:** Efficiently retrieve and organize expense records.
- **Input Validation:** Validate incoming API requests.
- **Exception Handling:** Global exception handling for consistent API error responses.
- **Layered Architecture:** Separation of Controller, Service, Repository, and Entity layers.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot | Backend framework |
| Spring Data JPA | Database operations |
| PostgreSQL | Relational database |
| Spring Security / JWT | Authentication and authorization |
| Maven | Dependency management and build tool |
| Postman | API testing |

## 🏗️ Project Architecture

The application follows a layered architecture to maintain separation of concerns and improve maintainability.

```text
Client (Postman / Frontend)
          |
          v
    Controller Layer
          |
          v
      Service Layer
          |
          v
    Repository Layer
          |
          v
      PostgreSQL
```

### Layer Responsibilities

- **Controller:** Handles HTTP requests and responses.
- **Service:** Contains business logic and expense management operations.
- **Repository:** Handles database interactions using Spring Data JPA.
- **Entity:** Represents database tables and their relationships.

## ⚙️ Getting Started

### Prerequisites

Make sure you have installed:

- Java 21 or later
- PostgreSQL
- Git
- Maven (optional, as the project includes Maven Wrapper)

### 1. Clone the Repository

```bash
git clone https://github.com/Dishakhabiya/expensetracker.git
```

### 2. Navigate to the Project

```bash
cd expensetracker
```

### 3. Configure PostgreSQL

Create a PostgreSQL database for the application.

Configure your database credentials in `application.properties` or through environment variables.

Example configuration:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Set the corresponding environment variables before starting the application.

### 4. Run the Application

Using Maven Wrapper:

**macOS / Linux**
```bash
./mvnw spring-boot:run
```

**Windows**
```bash
mvnw.cmd spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## 🔗 API Overview

Base URL:

```text
http://localhost:8080/api/expenses
```

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/expenses` | Create an expense |
| GET | `/api/expenses` | Retrieve all expenses |

Additional functionality includes expense search, category filtering, pagination, sorting, and update/delete operations.

Use Postman to test the REST APIs.

## 🔐 Security

The application implements JWT-based authentication and user-specific authorization to protect expense-related resources.

## 📌 Future Enhancements

- Monthly and yearly expense analytics.
- Interactive expense visualization dashboard.
- Budget management and spending limits.
- Docker-based deployment.
- Cloud deployment.
