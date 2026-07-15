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

        // ❌ Vulnerability: SQL Injection
        String unsafeUserInput = args.length > 0 ? args[0] : "1";
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + unsafeUserInput + "'");
        while (rs.next()) {
            System.out.println("User: " + rs.getString("name"));
        }

        // ❌ Code Smell: Dead code / meaningless condition
        if (true == true) {
            System.out.println("This is unnecessary logic");
        }

        // ❌ Code Smell: Empty catch block
        try {
            int z = Integer.parseInt("abc");
        } catch (Exception e) {
            // nothing here → SonarQube flags as code smell
        }

        // ❌ Code Duplication: Repeated logic
        printMessage("Hello");
        printMessage("Hello");
        printMessage("Hello"); // repeated again
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}
