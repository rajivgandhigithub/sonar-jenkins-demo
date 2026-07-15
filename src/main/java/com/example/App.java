package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        // ❌ Hardcoded credentials (SonarQube will flag this)
        String user = "admin";
        String password = "password123";

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", user, password);
        Statement stmt = conn.createStatement();

        // ❌ SQL Injection vulnerability: unsafe concatenation of user input
        String unsafeUserInput = args.length > 0 ? args[0] : "1";
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + unsafeUserInput + "'");

        while (rs.next()) {
            System.out.println("User: " + rs.getString("name"));
        }
    }
}
