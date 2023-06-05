package com.pratice.coderpad;

public class RotatingArray {
    public static int findSmallestNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated, the smallest number is at index 0
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The smallest number is in the right half of the array
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // The smallest number is in the left half of the array
                right = mid;
            } else {
                // In case of duplicates, move the right pointer to the left
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int smallestNumber = findSmallestNumber(nums);
        System.out.println("Smallest number: " + smallestNumber);
    }
}
