package com.pratice.coderpad;

import java.util.stream.IntStream;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, cleanStr.length() / 2)
                .allMatch(i -> cleanStr.charAt(i) == cleanStr.charAt(cleanStr.length() - i - 1));
    }

    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        if (isPalindrome(str)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}

