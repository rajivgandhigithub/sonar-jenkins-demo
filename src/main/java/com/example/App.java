package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        // ❌ Bug: Division by zero
        int x = 10;
        int y = 0;
        System.out.println("Result: " + (x / y));

        // ❌ Vulnerability: Hardcoded credentials
        String user = "admin";
        String password = "password123";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", user, password);
        Statement stmt = conn.createStatement();

        // ❌ Vulnerability: SQL Injection (unsafe concatenation of user input)
        String unsafeUserInput = args.length > 0 ? args[0] : "1";
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + unsafeUserInput + "'");
        while (rs.next()) {
            System.out.println("User: " + rs.getString("name"));
        }

        // ❌ Code Smell: Always true condition
        if (true == true) {
            System.out.println("This is a bad practice");
        }

        // ❌ Code Duplication: Same logic repeated twice
        printMessage("Hello");
        printMessage("Hello");
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}
