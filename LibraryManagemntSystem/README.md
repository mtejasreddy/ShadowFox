# Task 4: 📚 Library Management System

A Java-based **Library Management System** built using **Core Java, JDBC, and SQLite**. This project allows users to manage books efficiently with features like adding, viewing, searching, updating, deleting, borrowing, and returning books.

---

## 🚀 Features

- ➕ Add a new book
- 📖 View all books
- 🔍 Search books by title
- ✏️ Update book details
- 🗑️ Delete a book
- 📚 Borrow a book
- 🔄 Return a book
- ✅ Prevent duplicate books (Title + Author)
- 🛡️ Input validation for menu options
- 💾 Persistent storage using SQLite

---

## 🛠️ Technologies Used

- Java
- JDBC
- SQLite
- IntelliJ IDEA
- Git & GitHub

---

## 📂 Project Structure

```
LibraryManagementSystem/
│
├── src/
│   ├── database/
│   │     ├── DatabaseConnection.java
│   │     └── DatabaseInitializer.java
│   │
│   ├── dao/
│   │     └── BookDAO.java
│   │
│   ├── model/
│   │     └── Book.java
│   │
│   └── main/
│         └── Main.java
│
├── library.db
└── README.md
```

---

## 📷 Sample Output

```
=== Library Management System ===

1. Add Book
2. View Book
3. Search Book
4. Update Book
5. Delete Book
6. Borrow Book
7. Return Book
8. Exit

Enter your choice:
```

---

## ⚙️ How to Run

1. Clone this repository

```bash
git clone https://github.com/mtejasreddy/ShadowFox.git
```

2. Open the project in IntelliJ IDEA.

3. Ensure JDK 17 (or later) is installed.

4. Run `Main.java`.

5. The SQLite database (`library.db`) will be created automatically.

---

## 🧠 Concepts Practiced

- Object-Oriented Programming (OOP)
- JDBC
- SQLite Database
- DAO (Data Access Object) Pattern
- CRUD Operations
- PreparedStatement
- ResultSet
- Exception Handling
- Input Validation
- Business Logic Design

---

## 🔮 Future Improvements

- 👤 User Login System
- 📖 Search by Author
- 📅 Due Date Management
- ⏰ Overdue Fine Calculation
- 📊 Dashboard & Statistics
- 🌐 JavaFX GUI
- ☁️ MySQL Support
- 📚 Google Books API Integration

---

## 👨‍💻 Author

**M Tejas Reddy**

Passionate about Java, Data Structures & Algorithms, and Full Stack Development.

---

## ⭐ If you found this project useful, consider giving it a star!