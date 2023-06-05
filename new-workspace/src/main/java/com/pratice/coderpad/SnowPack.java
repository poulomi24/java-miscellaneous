package com.pratice.coderpad;

public class SnowPack {

    /*
     **  Find the amount of snow that could be captured.
     */
    public static Integer computeSnowpack(Integer[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }

        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        int snow = 0;
        for (int i = 0; i < arr.length; i++) {
            snow += (Math.max(0,Math.min(left[i], right[i]) - arr[i]));
        }
        System.out.println("snow:: " + snow);
        return snow;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
        result &= computeSnowpack(new Integer[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6;
        result &= computeSnowpack(new Integer[]{3, 0, 2, 0, 4}) == 7;

        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
