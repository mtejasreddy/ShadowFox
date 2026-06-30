package com.tejas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tejas.database.DatabaseConnection.URL;

public class DatabaseInitializer {

    public static void initializeDatabase(){
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement()
        ){
            String sql = """
                CREATE TABLE IF NOT EXISTS books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                author TEXT NOT NULL,
                year INTEGER,
                available BOOLEAN DEFAULT 1
            );
        """;
            statement.execute(sql);
            System.out.println("Books table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();        }
    }
}
