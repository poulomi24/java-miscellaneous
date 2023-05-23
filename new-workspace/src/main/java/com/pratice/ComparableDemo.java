package com.pratice;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ComparableDemo {
    public static void main(String[] args) {
        //CREATION
        List<Employee1> list = Arrays.asList(
                new Employee1("Poulomi", 30),
                new Employee1("Roni", 28),
                new Employee1("Rimi", 35),
                new Employee1("Sreeja", 25),
                new Employee1("Reya", 32),
                new Employee1("Anki", 32),
                new Employee1("Ritu", 25),
                new Employee1("Ritu", 25)
        );
        System.out.println("Before sorting::: ");
        list.stream().map(e -> e.getAge()).forEach(System.out::println);
        //SORTING
        Collections.sort(list);
        System.out.println("After sorting::: ");
        list.stream().map(e -> e.getAge()).forEach(System.out::println);

       int min =  list.stream().map(e -> e.getAge()).collect(Collectors.toList()).stream().mapToInt(x-> x).summaryStatistics().getMin();
        System.out.println("min:: " +min);

      List<Integer> slicedAges = list.stream().map(e -> e.getAge()).collect(Collectors.toList()).stream().sorted().skip(1).limit(2).collect(Collectors.toList());
        System.out.println("ages:: " +slicedAges);

        String namesInUpperCase = list.stream().map(e -> e.getName()).collect(Collectors.toList()).stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println("names in upper case:: " +namesInUpperCase);

        Map<Integer, Set<Employee1>> empMap = list.stream().collect(Collectors.groupingBy(x -> x.getAge(),TreeMap::new, Collectors.toSet()));
        System.out.println("map:: " +empMap);
        for(Map.Entry<Integer, Set<Employee1>> entry : empMap.entrySet())
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        Comparator<Employee1> employee1Comparator = Comparator.comparing(x -> x.getAge());
        list.stream().collect(Collectors.groupingBy(x ->x.getAge(),Collectors.reducing(BinaryOperator.maxBy(employee1Comparator))));

        System.out.println("$$$$$$$$");
        IntStream.rangeClosed(1,10).forEach(x -> System.out.println(Thread.currentThread().getName()+ " : "+x));
        System.out.println("===========");
        IntStream.rangeClosed(1,10).parallel().forEach(x-> System.out.println(Thread.currentThread().getName()+ " : "+x));
    }
}
