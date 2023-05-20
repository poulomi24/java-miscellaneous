package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(12,13,14,15,16,17);
        Long count = integerList.stream().filter(x->x%2==0).count();
        integerList.stream().filter(x->x%2==0).collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("count of even integers:: " +count);
    }
}
