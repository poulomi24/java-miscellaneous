package com.pratice.coderpad;

public class VowelCount {
    public static void main(String[] args) {
        String input = "Hello, World!";
        int vowelCount = countVowels(input);
        System.out.println("Vowel count: " + vowelCount);
    }

    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }
}

