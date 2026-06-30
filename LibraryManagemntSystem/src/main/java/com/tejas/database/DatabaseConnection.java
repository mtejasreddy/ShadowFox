package com.tejas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static final String URL = "jdbc:sqlite:library.db";

    public static Connection getConnection (){
        try{
            Connection connection = DriverManager.getConnection(URL);
            System.out.println("Connected to SQL Lite Database");
            return connection;
        } catch (SQLException e){
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
