package com.pratice;

import java.util.*;
import java.util.stream.Collectors;

public class MaxNum {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        int max = myList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("max:: " + max);
        Double average = myList.stream().filter(x -> x < 20).mapToDouble(Integer::doubleValue).summaryStatistics().getAverage();
        System.out.println("average:: " + average);
        Double average2 = myList.stream().filter(x -> x < 20).collect(Collectors.averagingDouble(Integer::doubleValue));
        System.out.println("average2::: " + average2);
        List<Integer>  evenNumbers = myList.stream().filter(x -> x%2==0).collect(Collectors.toList());
        System.out.println("even:: " +evenNumbers);
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = myList.stream().filter( x-> !set.add(x)).collect(Collectors.toList());
        System.out.println("duplicates:: " +duplicates);
        List<Integer> sortedList = myList.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted list:: "+sortedList);
        List<Integer> descendingOrder = myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sorted list in descending order:: "+descendingOrder);
    }
}