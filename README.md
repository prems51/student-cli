# Student CLI Management System

A structured command-line (CLI) application for managing student records using Java.
This project demonstrates core backend engineering concepts including layered architecture, data structures, validation, and file-based persistence.

---

## Overview

The system allows users to perform CRUD operations on student records through an interactive terminal interface. Data is stored persistently in a file and loaded into memory at application startup.

The application is designed with clear separation of concerns across multiple layers, simulating real backend architecture patterns.

---

## Features

### Core Functionality

* Add new student records
* View all students in formatted output
* Search students by ID (O(1)) and by name (O(n))
* Update existing student details
* Delete student records
* Persistent file storage (data retained across sessions)

### Validation

* Unique student ID enforcement using `HashMap`
* Email format validation
* Input validation for age and other fields

### Performance Characteristics

* Fast lookup using `HashMap<Integer, Student>`
* Efficient in-memory operations
* File rewrite for persistence after updates/deletions

---

## Project Structure

```
StudentCLI/
│
├── Main.java                  # Application entry point
│
├── model/
│   └── Student.java          # Data model representing a student
│
├── service/
│   ├── StudentService.java   # Core business logic
│   └── EmailValidator.java   # Email validation utility
│
├── database/
│   ├── FileManager.java      # File handling (read/write)
│   └── students.txt          # Persistent storage
│
├── ui/
│   └── Menu.java             # CLI interaction layer
│
├── test/
│   └── Test.java             # Basic testing utilities
│
└── .gitignore
```

---

## Architecture

This project follows a layered architecture:

* **Model Layer**

  * Represents the data structure (`Student`)

* **Service Layer**

  * Contains business logic and validation rules
  * Handles operations like add, update, delete, search

* **Database Layer**

  * Manages file-based persistence
  * Reads from and writes to `students.txt`

* **UI Layer**

  * Provides an interactive CLI menu
  * Handles user input and output

---

## Data Storage

Student data is stored in:

```
database/students.txt
```

### Format (CSV)

```
studentId,name,age,course,branch,enrollmentYear,phone,email
```

Example:

```
101,Rahul,20,CSE,AI,2024,9876543210,rahul@email.com
```

---

## Data Structures

Primary data structure:

```
HashMap<Integer, Student>
```

* Key → `studentId`
* Value → `Student object`

Benefits:

* O(1) lookup by ID
* Efficient updates and deletions
* Ensures uniqueness of student IDs

---

## Time Complexity

| Operation      | Complexity |
| -------------- | ---------- |
| Search by ID   | O(1)       |
| Search by Name | O(n)       |
| Add Student    | O(1)       |
| Delete Student | O(n)*      |
| Update Student | O(n)*      |

* Due to full file rewrite during persistence.

---

## Setup Instructions

### Prerequisites

* Java JDK 8 or higher

Check version:

```
java -version
```

---

### Compile

From project root:

```
javac Main.java model/*.java service/*.java database/*.java ui/*.java test/*.java
```

---

### Run Application

```
java Main
```

---

### Run Tests

```
java test.Test
```

---

## Usage

Example menu:

```
===== Student Management System =====
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
```

Follow prompts to perform operations.

---

## Error Handling

* Handles missing or unreadable file scenarios
* Prevents duplicate student IDs
* Validates input formats (email, age, etc.)
* Handles empty dataset cases

---

## Limitations

* File-based storage (not scalable)
* Full file rewrite on update/delete
* No concurrency handling
* Basic test coverage

---

## Future Improvements

* Replace file storage with database (MySQL/PostgreSQL)
* Convert into REST API using Spring Boot
* Add authentication and role-based access
* Improve logging and error handling
* Introduce unit testing frameworks (JUnit)

---

## Learning Outcomes

This project demonstrates:

* Object-Oriented Programming (OOP)
* Layered architecture design
* Data structures in real applications
* File handling and persistence
* Input validation and error handling

---

## Author

Developed as part of backend learning and system design practice.
