package com.example.myapplication;

public class Counter {

    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+|,|\\.");
        return words.length;
    }

    public static int countCharacters(String input) {
        if (input == null) {
            return 0;
        }
        return input.length();
    }
}
