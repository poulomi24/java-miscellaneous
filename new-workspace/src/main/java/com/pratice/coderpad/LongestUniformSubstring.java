package com.pratice.coderpad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstring {
    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){
        if (input == null || input.length() == 0) {
            return new int[]{-1,0};
        }

        int longestStart = 0;
        int longestLength = 1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > longestLength) {
                    longestStart = currentStart;
                    longestLength = currentLength;
                }

                currentStart = i;
                currentLength = 1;
            }
        }

        if (currentLength > longestLength) {
            longestStart = currentStart;
            longestLength = currentLength;
        }
        return new int[] {longestStart, longestLength};
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});
        testCases.put("abaababaab", new int[]{2, 2});
        testCases.put("aaaaaaaaaaa", new int[]{0, 11});
        testCases.put("aabbcccccccc", new int[]{4, 8});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}
