# RBDMS Demo – Spring Boot with Custom In-Memory Database

This project is a **Spring Boot application** integrated with a **custom-built in-memory relational database engine**.  
The database runs locally in memory and is accessed through a simple SQL parser, without using any external database system.

---

## How the Application Works

- The in-memory database is included as a **local dependency** in the project.
- In order for the spring boot application to work, you need to run the simple rdbms java application first **mvn clean install** so that maven creates it as a local library which is then imported by the Spring boot application when it runs, 
without this step the application will not run.
- When the Spring Boot application starts:
    - The database is initialized in memory
    - Required tables are created automatically
- All data exists **only while the application is running**.

---

## Architecture Overview

- **Spring Boot** – REST API layer
- **Service Layer** – Builds SQL strings and executes them
- **SQL Parser** – Parses and executes SQL commands
- **Database Engine** – Stores tables, rows, and columns in memory

---

## Requirements

- Java 21+
- Maven
- Postman (for testing the API)

---

## Running the Application

### Step 1: Build the project

```bash
  mvn clean install
  mvn spring-boot:run
```

### In Memory Database Behavior
- The database is not persisted
- No files are written to disk
- Restarting the app resets all tables and records
- The RDBMS must exist locally as a dependency for the application to work

## API Usage (CRUD Operations)
After starting the application, use Postman to interact with the API.

### Postman Collection
https://embarkx.postman.co/workspace/My-Workspace~3618d738-8c27-40a2-8e52-18d9e59a6670/collection/37802113-33b2bab3-9597-4d73-9f6e-e6aec77246e9?action=share

### Supported Operations
1. Create User
2. Get All Users
3. Update User Email
4. Delete User


## Limitations
- No joins
- Simple SQL syntax only
- No persistence
- Single in-memory instance

## IMPORTANT NOTE
In order for the spring boot application to work, you need to run the simple rdbms java application first **mvn clean install** so that maven creates it as a local library which is then imported by the Spring boot application when it runs,
without this step the application will not run.
