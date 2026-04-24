[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/5TmsgegP)
# web-jsp-jdbc-mvc

# University Course Registration System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

A Spring MVC web application for managing student course registrations with authentication, course management, and logging features.

## Features

- **User Authentication**: Secure login/logout for students
- **Course Management**: View and register for available courses
- **Registration System**: Track student enrollments
- **Activity Logging**: Interceptor-based action tracking
- **Database Integration**: MySQL backend with JDBC
- **Version Control**: Git-based development workflow


## Test Credentials

Use these credentials to log in and test the application:

| Student Name        | Email                    | Password  |
|--------------------|--------------------------|-----------|
| Wasana Karunanayaka | s21081@sci.pdn.ac.lk    | wasana123 |
| Nisha Fonseka       | s21180@sci.pdn.ac.lk    | nisha123  |

## Database Configuration

- Database name: `university_db`
- MySQL username: `root`
- MySQL password: `password`
- Port: `3306`

## How to Run

1. Import `university_db` into MySQL and run the table setup SQL
2. Deploy the WAR on Apache Tomcat 9
3. Visit: `http://localhost:8080/course-registration/login`

## Technologies Used

- **Backend**: Spring MVC, JDBC
- **Frontend**: JSP, Bootstrap
- **Database**: MySQL
- **Tools**: Maven, Git, Tomcat

## Installation

### Prerequisites
- Java JDK 8+
- Apache Tomcat 9+
- MySQL 5.7+
- Maven 3.6+

### Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/university-registration-system.git
   cd university-registration-system


src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── university/
│   │           ├── controller/       # Spring controllers
│   │           ├── dao/              # Database operations
│   │           ├── interceptor/      # Logging components
│   │           └── model/            # Data models
│   ├── resources/                    # Configuration files
│   └── webapp/
│       ├── WEB-INF/
│       │   └── views/                # JSP pages
│       └── static/                   # CSS/JS assets
├── test/                             # Test cases
