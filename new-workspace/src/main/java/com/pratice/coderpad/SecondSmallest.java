package com.pratice.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondSmallest {
    /**
     * int secondSmallest(int[] x)
     */
    public static int secondSmallest(int[] x) {
        if (x.length < 2) {
            return 0;
        }

        int sortedArray = Arrays.stream(x)
                .sorted()
                .skip(1).findFirst().getAsInt();

        return sortedArray;
    }

    public static int secondLargest(int[] x) {
        if (x.length < 2) {
            return 0;
        }

        int sortedArray = Arrays.stream(x)
                .sorted()
                .skip(x.length-2).findFirst().getAsInt();

        return sortedArray;
    }

    public static List<Integer> reverse(int[] x) {
        if (x.length < 2) {
            return new ArrayList<>();
        }

        List<Integer> sortedArray = Arrays.stream(x).boxed()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return sortedArray;
    }

    public static void main(String args[]) {

        int[] a = {0};
        int[] b = {0, 1};
        int[] c = {9, 3, 6, 1, 2, 8, 4, 7, 5};

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;
        result &= secondSmallest(c) == 2;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}