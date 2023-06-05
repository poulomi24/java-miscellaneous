package com.pratice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        (new Random()).ints().limit(5).sorted().forEach(System.out::println);
       int sum =  myList.stream().reduce(myList.get(0), Integer::sum);
        System.out.println("sum:: " +sum);

        List<Integer> integerList = Arrays.asList(2,5,11,12,13,14);
      Double squaredAverage =  integerList.stream().map(x -> Math.pow(x,2)).filter(x -> x>100).mapToDouble(x -> x.doubleValue()).summaryStatistics().getAverage();
        Double squaredAverage2 =  integerList.stream().map(x -> Math.pow(x,2)).filter(x -> x>100).collect(Collectors.averagingDouble(x ->x.doubleValue()));
        System.out.println("squaredAverage:: " +squaredAverage2);

        System.out.println(integerList.stream().mapToInt(Integer::intValue).summaryStatistics().getMax());

        List<List<String>> Names = Arrays.asList(Arrays.asList("Saket", "Trevor"), Arrays.asList("John", "Michael"),
                Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean"));

        Names.stream().flatMap(x -> x.stream()).filter(x -> x.startsWith("S")).collect(Collectors.toList()).forEach(System.out::println);

        List<String> stringList = Arrays.asList("sunday","monday","tuesday","wednesday");
        List<String> stringList1 = Arrays.asList("thursday", "friday");
        System.out.println(stringList.stream().collect(Collectors.joining(" ,")));
        stringList.stream().filter(x -> x.length()>6).collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> dupList = Arrays.asList(21,21,22,23);
        dupList.stream().collect(Collectors.toSet()).forEach(System.out::println);
    }
}
