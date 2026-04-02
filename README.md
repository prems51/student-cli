# Student CLI Management System

A command-line interface (CLI) application for managing student records built with Java. This project provides a simple yet effective way to create, read, update, and manage student information with persistent file storage.

## Features

- **Student Records Management**: Add, view, update, and delete student information
- **Email Validation**: Built-in email validation for student records
- **Persistent Storage**: Student data is stored in files for persistence across sessions
- **Interactive Menu**: User-friendly command-line menu interface
- **Data Validation**: Comprehensive validation for student data entry
- **Search & Filter**: Easily search and view student information

## Project Structure

```
Student CLI/
├── Main.java                 # Application entry point
├── model/
│   └── Student.java         # Student data model
├── service/
│   ├── StudentService.java  # Business logic for student operations
│   └── EmailValidator.java  # Email validation utility
├── database/
│   ├── FileManage.java      # File I/O operations
│   └── students.txt         # Student data storage
├── ui/
│   └── Menu.java            # Interactive CLI menu
├── test/
│   └── Test.java            # Unit tests
└── .gitignore               # Git ignore configuration
```

## Requirements

- **Java 8** or higher
- No external dependencies (uses core Java libraries)

## Setup Instructions

### Prerequisites
Ensure you have Java Development Kit (JDK) installed on your system.

```bash
# Check Java version
java -version
```

### Compilation

Navigate to the project directory and compile all Java files:

```bash
javac *.java model/*.java service/*.java database/*.java ui/*.java test/*.java
```

Or use your IDE's build functionality (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Running the Application

From the project root directory:

```bash
java Main
```

The application will launch the interactive menu where you can:
- Add new students
- View all students
- Search for specific students
- Update student information
- Delete student records
- Exit the application

### Running Tests

To run the test suite:

```bash
java test.Test
```

## Usage Example

After launching the application, you'll see an interactive menu:

```
===== Student Management System =====
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice: 
```

Follow the on-screen prompts to perform operations.

## Data Format

Student records are stored in `database/students.txt` with the following information:
- Student ID
- Name
- Age
- Course
- Branch
- Enrollment Year
- Contact Number
- Department

## Development

This project follows a layered architecture:
- **Model Layer**: `Student.java` - Data representation
- **Service Layer**: Business logic and validation
- **Database Layer**: File-based persistence
- **UI Layer**: Command-line interface

## Contributing

To extend this project:
1. Add new features in the service layer
2. Update the menu in `Menu.java`
3. Add corresponding tests in `test/Test.java`
4. Ensure data validation through `EmailValidator` and `StudentService`

## License

This project is educational material for college coursework.

## Author

Created as a college project for learning Java CLI development.
