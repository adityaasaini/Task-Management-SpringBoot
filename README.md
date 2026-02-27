📝 TaskPro: Full-Stack Task Management System
-
TaskPro is a robust, full-stack web application designed to manage daily tasks efficiently. Built using Spring Boot and Vanilla JavaScript, it demonstrates a clean separation of concerns between the backend logic and a modern, responsive frontend.

🚀 Features
-
Complete CRUD: Create, Read, Update, and Delete tasks seamlessly.

Search by ID: Quickly find specific tasks using their unique identifiers.

Modern UI: A sleek dashboard built with Glassmorphism design principles.

Persistence: Data is safely stored in a MySQL database.

API Documentation: Fully documented endpoints using Swagger/OpenAPI.

🛠️ Tech Stack
-
Backend: Java 24, Spring Boot 3.x, Spring Data JPA

Database: MySQL

Frontend: HTML5, CSS3, JavaScript (Fetch API)

Testing & Docs: Swagger UI, Postman

📂 Project Structure
-
Plaintext
src/main/java/com/example/test/
├── controller/    # REST Endpoints (TaskController)
├── entity/        # Database Model (Task)
├── repository/    # Data Access Layer (TaskRepository)
├── service/       # Business Logic (TaskService)
└── exception/     # Global Error Handling

src/main/resources/
├── static/        # Frontend files (index.html, style.css, script.js)
└── application.properties # Database & App configs
⚙️ Setup & Installation
Clone the repo:

Bash
-
git clone https://github.com/your-username/Task_Mangment.git
Database Setup: Create a database named task_db in MySQL.

Configure Properties: Update src/main/resources/application.properties with your MySQL username and password.

Run Application: Run TaskMangmentApplication.java from your IDE (STS/IntelliJ).

Access: Open http://localhost:8080 in your browser.


🔍 API Documentation
-
Once the app is running, you can explore and test the APIs directly through Swagger:
👉 URL: http://localhost:8080/swagger-ui/index.html

⚠️ Challenges Overcome
-
This project was a great learning experience where I tackled several real-world development hurdles:

Ambiguous Mapping: Resolved conflicts where multiple methods were mapped to the same URI pattern.

CORS Configuration: Handled Cross-Origin Resource Sharing to allow the JS frontend to communicate securely with the Spring Boot backend.

Exception Handling: Implemented Global Exception Handling to manage RuntimeException and provide clear API responses.

👤 Author
Aditya Saini
-
Aspiring Java Full-Stack Developer
