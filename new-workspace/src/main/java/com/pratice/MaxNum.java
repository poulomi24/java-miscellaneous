package com.pratice;

import java.util.*;

public class MaxNum {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        int max = myList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("max:: " +max);
    }
}
