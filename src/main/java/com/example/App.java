package com.example;

public class App {
    public static void main(String[] args) {
        int x = 10;
        int y = 2;
        System.out.println("Result: " + safeDivide(x, y));
        printMessage("Hello, SonarQube!");
    }

    // ✅ Bug-free division
    public static int safeDivide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    // ✅ Simple reusable method
    public static void printMessage(String msg) {
        if (msg == null || msg.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        System.out.println(msg);
    }
}

