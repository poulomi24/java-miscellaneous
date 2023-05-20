package com.pratice;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicateUsingStream {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> integerSet = new HashSet<>();
        myList.stream().filter(x -> !integerSet.add(x)).forEach(System.out::println);
    }
}
