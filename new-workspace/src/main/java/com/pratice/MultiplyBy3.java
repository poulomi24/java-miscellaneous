package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiplyBy3 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream().map(x -> x*3).collect(Collectors.toList()).forEach(System.out::println);
        IntStream.of(3,4,5).map(x -> x*2).boxed().collect(Collectors.toList()).forEach(System.out::println);
    }
}
