package com.pratice;

import java.util.Arrays;
import java.util.List;

public class LengthGreaterThan3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("I","am","just","not","ready","for","Monday");
        long count = strings.stream().filter( i -> i.length() >3).count();
        System.out.println("count:: " +count);
    }
}
