package com.pratice.coderpad;

import java.util.Arrays;
import java.util.stream.Stream;

public class SUm {
    public static void main(String[] args) {
        int a = 0,b = 0;
        int sum = a+b;
        System.out.println(sum);

        int[] arr = {2,5,9,8,3};
        System.out.println(Arrays.stream(arr).boxed().sorted((o1,o2) -> o2-o1).skip(1).findFirst().get());

    }
}
