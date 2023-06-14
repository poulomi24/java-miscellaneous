package com.pratice.coderpad;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = findMaximumSubarraySum(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }

    public static int findMaximumSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

