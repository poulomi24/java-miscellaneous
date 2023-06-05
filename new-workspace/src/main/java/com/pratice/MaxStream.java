package com.pratice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MaxStream {
    public static void main(String[] args) {
        Integer[] arr = {9,1,2,4,24,98,45,63};
        List<Integer> arrays = Arrays.asList(arr);
        int max = arrays.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(2).findFirst().get();
        int secondSmallest = arrays.stream().sorted(Comparator.comparing(Integer::intValue)).skip(1).findFirst().get();
        System.out.println("max:: " +max);
        System.out.println("secondSmallest:: " +secondSmallest);
    }
}
