package com.company;

public class Main {
    private static String token = "";

    public static void setToken(String newToken) {
        token = newToken;
    }

    public static String getToken() {
        return token;
    }

    public static void main(String[] args) {
        StartMenu stm = new StartMenu("Title");
    }
}
