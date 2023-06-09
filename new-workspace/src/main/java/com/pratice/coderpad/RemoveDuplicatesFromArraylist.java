package com.pratice.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArraylist {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5,2,6,3,7,6,5};
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toSet()));

        System.out.println(Arrays.stream(arr).filter(x -> x%2==0).summaryStatistics().getSum());

        System.out.println(Arrays.stream(arr).mapToDouble(Double::valueOf).average().getAsDouble());

        System.out.println(Arrays.stream(arr).summaryStatistics().getAverage());
    }
}
