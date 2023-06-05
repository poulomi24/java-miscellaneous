package com.pratice.coderpad;

public class MAin {
    public static int findCycleLength(int[] nums) {

        final boolean[] visited = new boolean[nums.length];
        int count = 0;
        int visitNow = 0;
        while (true) {
            try {
                if (visited[visitNow]) return count;

                visited[visitNow] = true;
                visitNow = nums[visitNow];
                count++;
            } catch (final ArrayIndexOutOfBoundsException ex) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 2}; // Example array with a cycle of length 3
        int cycleLength = findCycleLength(nums);
        System.out.println("Cycle Length: " +cycleLength);
    }
}
