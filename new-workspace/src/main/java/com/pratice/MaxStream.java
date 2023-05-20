package com.pratice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MaxStream {
    public static void main(String[] args) {
        Integer[] arr = {9,1,2,4,24,98,45,63};
        List<Integer> arrays = Arrays.asList(arr);
        int max = arrays.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("max:: " +max);
    }
}
