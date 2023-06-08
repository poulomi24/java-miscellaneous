package com.pratice.coderpad;

import java.util.HashSet;
import java.util.Set;

public class UniqueTuples {
    public static HashSet<String> uniqueTuples(String input, int len) {
        HashSet<String> uniqueTuples = new HashSet<>();

        for (int i = 0; i <= input.length() - len; i++) {
            StringBuilder tupleBuilder = new StringBuilder();
            for (int j = i; j < i + len; j++) {
                tupleBuilder.append(input.charAt(j));
            }
            uniqueTuples.add(tupleBuilder.toString());
        }

        return uniqueTuples;
    }

    public static void main(String[] args) {
        String input = "aab";
        HashSet<String> result = uniqueTuples(input, 2);
        if (result.contains("aa") && result.contains("ab")) {
            System.out.println("Test passed.");

        } else {
            System.out.println("Test failed.");

        }
    }
}
