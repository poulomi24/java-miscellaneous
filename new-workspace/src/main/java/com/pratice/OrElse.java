package com.pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrElse {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,5,7,9);
        System.out.println("first even::  " +getEven(numbers));
    }

    public static int getEven(List<Integer> numList){
        return numList.stream().filter(num -> num%2==0).findAny().orElse(0);
    }
}
