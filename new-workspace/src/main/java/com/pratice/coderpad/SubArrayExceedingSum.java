package com.pratice.coderpad;
import java.lang.Math;
public class SubArrayExceedingSum {

    public static int subArrayExceedsSum(int arr[], int target) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int val_sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            val_sum += arr[i];
            while (val_sum >= target) {
                result = Math.min(result, i + 1 - left);
                val_sum -= arr[left];
                left++;
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        boolean result = true;
//        int[] arr = {1, 2, 3, 4};
//        result = result && subArrayExceedsSum(arr, 6) == 2;
//        result = result && subArrayExceedsSum(arr, 12) == -1;
        int[] arr = {2, 3, 1, 2, 4, 3};
        int[] brr = {1, 4, 45, 6, 0, 19};
        int[] brr1 ={};
        result = result && subArrayExceedsSum(arr, 7) == 2;
        result = result && subArrayExceedsSum(arr, 6) == 2;
        result = result && subArrayExceedsSum(arr, 13) == 5;
        result = result && subArrayExceedsSum(brr, 51) == 2;
        result = result && subArrayExceedsSum(brr1, 1) == -1;


        if (result) {
            System.out.println("All tests pass\n");
        } else {
            System.out.println("There are test failures\n");
        }
    }
}
