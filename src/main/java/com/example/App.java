package com.example;

public class App {
    public static void main(String[] args) {

        int x = 10;
        int y = 0; // ❌ Bug

        System.out.println(x / y);

        if (true == true) { // ❌ Code smell
            System.out.println("bad");
        }

        String password = "123456"; // ❌ Vulnerability
    }
}
