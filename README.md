# 📝 System Management Task

A simple full-stack task management system built with **Spring Boot** (Backend) and React (Frontend).
Includes  Dependency Injection, RESTful API, validation, and a user-friendly interface.

---

## 📂 Project Structure

```
system-management-task/
├── backend/                  # Spring Boot application
│   ├── controller            # REST API endpoints
│   ├── dto                   # TaskRequest and ApiResponse wrappers
│   ├── exception             # Global exception handling
│   ├── model                 # Task entity
│   ├── repository            # Task repository
│   ├── service               # Business logic
|   ├── WebConfig.java        # CORS Policy Configuration
│   └── MinimalTaskManagerApplication.java
│
├── frontend/                   # React frontend
│   ├── public/
│   ├── src/
│   │   ├── api/              # Centralized Axios API calls
│   │   ├── components/       # Form and task list components
│   │   ├── App.jsx            # Main app component
│   │   └── index.js
│   └── package.json
```

---

## 🔧 Features

### Backend

* Add new tasks
* Get all tasks
* Get a task by ID
* Mark a task as completed
* Delete a task
* Global exception handler for validation errors
* Well-structured responses using a custom `ApiResponse` wrapper

### Frontend

* Create a task via a form
* List all tasks with scrollable UI
* Mark tasks as completed
* Delete tasks
* Responsive design using Bootstrap
* Client-side validation with helpful error messages
* Axios-based API communication

---

## 🚀 Technologies Used

### Backend

| Technology      | Description           |
| --------------- | --------------------- |
| Java 24         | Programming language  |
| Spring Boot     | Main framework        |
| Spring Web      | REST API layer        |
| Spring Data JPA | Repository management |
| H2 Database     | In-memory database    |
| Lombok          | Boilerplate reduction |
| Postman         | API testing           |

### Frontend

| Technology      | Description                    |
| --------------- | -------------------------------|
| React           | Frontend SPA framework         |
| Bootstrap 5     | Styling and responsive layout  |
| React Hooks     | State and lifecycle management |

---

## 🚪 API Endpoints

| Method | Endpoint    | Description            |
| ------ | ----------- | ---------------------- |
| POST   | /tasks      | Add a new task         |
| GET    | /tasks      | Get all tasks          |
| GET    | /tasks/{id} | Get task by ID         |
| PUT    | /tasks/{id} | Mark task as completed |
| DELETE | /tasks/{id} | Delete a task          |

### Sample Request (POST /tasks)

```json
{
    "taskName":"Clean the kitchen",
    "taskDescription":"Wash the dishes and wipe the counters"
}
```

### Sample Response (Wrapped)

```json
{
    "success": true,
    "message": "Task created successfully",
    "data": {
        "id": 1,
        "name": "Clean the kitchen",
        "description": "Wash the dishes and wipe the counters",
        "completed": false
    }
}
```

---

## 🚫 Exception Handling

Handled globally using a `@ControllerAdvice`:

* Returns structured error messages when validations fail.

```json
{
  "taskDescription": "Description must not exceed 100 characters",
  "taskName": "Name of task is required"
}
```

---

## 🔄 Run Locally

**Clone the repo**

```bash
git clone https://github.com/HadasAmar/system-managment-task.git
cd system-managment-task
```

### Backend Setup (Spring Boot)

1. **Run** `MinimalTaskManagerApplication.java`

2. **H2 Console** 

* URL: `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:mem:testdb`
* Username: `hadas`

**Runs on: http://localhost:8080**

### Frontend Setup (React)

```bash
cd frontend
npm install
npm start
```
**Runs on: http://localhost:3000**

---

## 🧪 Demo Task Flow

This project includes a demo task flow that runs automatically when the application starts. It demonstrates:

- Adding sample tasks (e.g., baking a cake, read a book, cleaning the room)
- Listing all tasks
- Marking a task as completed
- Deleting a task
- Handling attempts to update or delete non-existent tasks with appropriate messages

You can see the demo output in the console when running the application.

---

## 📊 Postman Collection

A Postman collection is included for testing of all endpoints.

1. Open Postman
2. Go to **Import** > **Choose File**
3. Select the file: `postman/task_manager.postman_collection.json`
4. Start testing!

You can also [download the collection here](./backend/postman/task_manager.postman_collection.json)

---

### 📸 Screenshot

![screenShot](https://github.com/user-attachments/assets/8795cda3-789e-40b7-af66-92a976df6e1a)

## 📅 Author

Developed by **Hadas Amar**
