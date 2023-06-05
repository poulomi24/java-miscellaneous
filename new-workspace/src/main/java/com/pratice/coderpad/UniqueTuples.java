package com.pratice.coderpad;

import java.util.HashSet;
import java.util.Set;

public class UniqueTuples {
    public static HashSet<String> uniqueTuples(String input, int len) {
        HashSet<String> uniqueTuples = new HashSet<>();
        StringBuilder currentTuple = new StringBuilder();
        Set<String> visited = new HashSet<>();

        generateUniqueTuples(input, len, 0, currentTuple, uniqueTuples, visited);

        return uniqueTuples;
    }

    private static void generateUniqueTuples(String input, int tupleSize, int startIndex, StringBuilder currentTuple,
                                             Set<String> uniqueTuples, Set<String> visited) {
        if (currentTuple.length() == tupleSize) {
            String tuple = currentTuple.toString();
            if (!visited.contains(tuple)) {
                uniqueTuples.add(tuple);
                visited.add(tuple);
            }
            return;
        }

        for (int i = startIndex; i < input.length(); i++) {
            currentTuple.append(input.charAt(i));
            generateUniqueTuples(input, tupleSize, i + 1, currentTuple, uniqueTuples, visited);
            currentTuple.deleteCharAt(currentTuple.length() - 1);
        }
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
