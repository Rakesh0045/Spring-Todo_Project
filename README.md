
# 📝 To-Do List Web Application

A simple and elegant To-Do List web app built using **Spring Boot**, **Thymeleaf**, **HTML/CSS**, and basic **Java** collections for backend storage. This project demonstrates how to build a full-stack web application without using a database — all tasks are stored in memory during runtime.

---

## 📸 Preview

![To-Do App UI](images/todo.png)

---

## 🚀 Features

- ✅ Add new tasks
- 🔁 Mark tasks as completed / uncompleted
- 🗑️ Delete tasks
- 🌈 Beautiful UI with gradient background and clean layout
- 🧠 Server-side logic using Spring Boot MVC and Thymeleaf templating

---

## 📂 Project Structure

```

todo\_app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/todo/todo\_app/
│       │       ├── TodoAppApplication.java
│       │       ├── Todo.java
│       │       └── TodoController.java
│       └── resources/
│           ├── static/
│           │   ├── css/
│           │   │   └── style.css
│           │   └── images/
│           │       ├── todo.png
│           │       ├── checked.png
│           │       └── unchecked.png
│           └── templates/
│               └── index.html
├── pom.xml
└── README.md

````

---

## ⚙️ How It Works

### Flow:
1. User visits `/` endpoint → Displays all tasks.
2. User submits task via form → POST request to `/add`.
3. Task is added to the list, and redirected to `/`.
4. User clicks on task → Toggles completion via `/toggle/{id}`.
5. User clicks on 🗑️ → Task deleted via `/delete/{id}`.

### Controllers:
- `GET /` → Loads homepage with list.
- `POST /add` → Adds a new task.
- `GET /toggle/{id}` → Toggles completed state.
- `GET /delete/{id}` → Deletes the task.

---

## 📦 Technologies Used

- **Java 17+**
- **Spring Boot**
- **Thymeleaf**
- **HTML / CSS**
- **Maven**

---

## 🛠️ Setup Instructions

### Prerequisites:
- Java 17+
- Maven
- IDE (IntelliJ, Eclipse, VSCode)

### Steps:

```bash
# Clone the repository
git clone https://github.com/your-username/todo_app.git
cd todo_app

# Run the Spring Boot application
./mvnw spring-boot:run
````

Or run via your IDE with the `TodoAppApplication` class.

Then open your browser and go to:

```
http://localhost:8080
```

---

## 📌 Notes

* No database is used — all data is stored in-memory and will reset on app restart.
* Use of `List<Todo>` for task storage keeps it beginner-friendly.

---

## 📷 UI Snapshot

### Main Interface:

![UI Screenshot](images/screenshot.png)

---

## ✨ Improvements You Can Try

* Add a database like H2 or MySQL.
* Implement session management.
* Add due dates and priority for tasks.
* Add user login/authentication.
* Use JavaScript for AJAX-based operations.

---

## 📄 License

This project is open-source and free to use under the [MIT License](LICENSE).

---

## 🔗 Connect

Feel free to fork, contribute, or raise issues!

**Made with 💙 by \[Rakesh]**


