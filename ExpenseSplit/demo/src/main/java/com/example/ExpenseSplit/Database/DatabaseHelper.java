package com.example.ExpenseSplit.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:src/main/resources/database.sqlite";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return null;
        }
    }

    public static void createTables() {
        String groupTable = "CREATE TABLE IF NOT EXISTS groups (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)";
        String memberTable = "CREATE TABLE IF NOT EXISTS members (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, group_id INTEGER, FOREIGN KEY(group_id) REFERENCES groups(id))";
        String expenseTable = "CREATE TABLE IF NOT EXISTS expenses (id INTEGER PRIMARY KEY AUTOINCREMENT, amount REAL, description TEXT, group_id INTEGER, FOREIGN KEY(group_id) REFERENCES groups(id))";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(groupTable);
            stmt.execute(memberTable);
            stmt.execute(expenseTable);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}
