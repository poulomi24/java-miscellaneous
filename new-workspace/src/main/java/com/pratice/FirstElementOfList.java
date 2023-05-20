package com.pratice;

import java.util.*;

public class FirstElementOfList {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        int num = myList.stream().findFirst().get();
        System.out.println("num:: " +num);
    }
}
