package com.pratice.coderpad;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    /**
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     **/
    public static char findFirst(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty.");
        }
        // code goes here
        Map<Character, Integer> map = new HashMap<>(input.length());
        char[] ch = input.toCharArray();
//        for (char c : input.toCharArray())
//            map.put(c, map.getOrDefault(c,0)+1);
//        System.out.println("map:: " + map);
//        for( char c : input.toCharArray())
//        {
//            if(map.get(c)==1)
//                return c;
//        }

       Map<Character, Long> charMap =input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(char c : input.toCharArray())
        {
            if(charMap.get(c)==1)
                return c;
        }
        return ('a');
    }

    public static void main(String args[]) {

        String s = "aab";
       String s1=  s.substring(2);
        System.out.println("s1:: "+s1);
        String[] inputs = {"apple", "racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd'};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

}

