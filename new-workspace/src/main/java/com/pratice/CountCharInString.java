package com.pratice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharInString {
    static String input = "subscribeToInterviewMania";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray())
        {

            if(map.containsKey(c))
                    map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            {
                System.out.println(entry.getKey() + " : " +entry.getValue());
            }
        }
        System.out.println("for set");
        List<char[]> stringList = Arrays.asList(input.toCharArray());
        Set<char[]> mySet = new HashSet<>();
        stringList.stream().filter(x -> !mySet.add(x)).forEach(System.out::println);

        System.out.println("**********");
        Map<String, Long> countMap = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(countMap);
    }
}
