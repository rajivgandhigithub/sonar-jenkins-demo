package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {
        // ✅ No division by zero
        int x = 10;
        int y = 2;
        System.out.println("Result: " + (x / y));

        // ✅ Credentials should be externalized (e.g., environment variables or config)
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", user, password)) {
            // ✅ Use PreparedStatement to avoid SQL injection
            String query = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String safeUserInput = args.length > 0 ? args[0] : "1";
                pstmt.setString(1, safeUserInput);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("User: " + rs.getString("name"));
                    }
                }
            }
        } catch (Exception e) {
            // ✅ Proper exception handling
            System.err.println("Database error: " + e.getMessage());
        }

        // ✅ No unnecessary conditions or duplication
        printMessage("Hello, SonarQube!");
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}
