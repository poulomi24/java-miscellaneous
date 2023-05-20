package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StaringWith1 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(12,3,24,35,16,47);
        Long count = integerList.stream().map(x -> x+"").filter(x->x.startsWith("1")).count();
        System.out.println("count of integers starting with 1:: " +count);
        integerList.stream().map(x -> x+"").filter(x->x.startsWith("1")).forEach(System.out::println);
        boolean result = integerList.stream().map(x->x+"").anyMatch(x ->x.startsWith("1"));
        System.out.println("Result:: " +result);
    }
}
