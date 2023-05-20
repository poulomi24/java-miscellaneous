package com.pratice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcat {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("I ", "am ", "not ");
        List<String> list2 = Arrays.asList("ready ","for ", "Monday ");
        Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList()).forEach(System.out::print);
    }
}
