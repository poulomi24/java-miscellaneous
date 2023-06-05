package com.pratice;

import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateUsingStream {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> integerSet = new HashSet<>();
        myList.stream().filter(x -> !integerSet.add(x)).forEach(System.out::println);

        String str = "ArrayList";
        List<String> stringList = new ArrayList<String>(Arrays.asList(str.split(",")));
        Map<String, Long> map = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map:: " + map);


                str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) ->
                {
                    if (v > 1)
                        System.out.println(k + " : " + v);
                });


       // System.out.println("map2:: " + map2);

    }
}
