Great! Here's an updated version of the `README.md` tailored for running the project with IntelliJ IDEA:

---

# 💸 Expense Splitter Application

A simple Spring Boot application for splitting expenses among a group of people. This can serve as the backend for applications like Splitwise.

## 🧰 Features

- Spring Boot based backend
- Easily extendable architecture for REST APIs
- Ready to connect with frontend clients or databases

## 🚀 Getting Started

### Prerequisites

- Java 17+
- IntelliJ IDEA (Community or Ultimate edition)
- Maven (usually bundled with IntelliJ)

### Running the Application in IntelliJ

1. Open IntelliJ IDEA.
2. Click **File > Open** and select the project directory.
3. Wait for Maven to finish indexing and downloading dependencies.
4. Navigate to `ExpenseSplitterApplication.java`.
5. Click the green **Run** button next to the `main` method or right-click and choose **Run 'ExpenseSplitterApplication.main()'**.

### Building a JAR (Optional)

If you want to run the application from the terminal:

```bash
mvn clean package
java -jar target/expense-splitter-0.0.1-SNAPSHOT.jar
```

## 📁 Project Structure

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── splitter/
                    └── ExpenseSplitterApplication.java
```

## 📌 Future Enhancements

- Add REST APIs for managing expenses and users
- Connect to a database (e.g., PostgreSQL or MySQL)
- Add authentication and user management
- Create a frontend UI

## 📄 License

MIT License

---

Let me know if you'd like this formatted as a downloadable file or want to include instructions for database or frontend integration!
