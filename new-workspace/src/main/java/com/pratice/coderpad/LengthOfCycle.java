package com.pratice.coderpad;

public class LengthOfCycle {

    /**
     *
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     *
     */
    public static int countLengthOfCycle( int[] arr, int startIndex ) {

        if(arr==null || arr.length==0 || startIndex<0 || startIndex>=arr.length)
            return -1;
        int count = 1;
        int fast = arr[arr[startIndex]];
        int slow = arr[startIndex];
        while(fast!=slow)
        {
            if(fast>= arr.length)
                return -1;
            count++;
            fast = arr[arr[fast]];
            slow = arr[slow];
        }
        System.out.println(count);
        return count;
    }


    public static void main( String[] args ) {

        boolean testsPassed = true;

        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4, 5, 2}, 0) == 4;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 1}, 0) == 3;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4}, 0) == -1;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4}, -1) == -1;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4}, 4) == -1;
        testsPassed &= countLengthOfCycle(new int[]{2, 3, 4, 0}, 0) == -1;
        testsPassed &= countLengthOfCycle(new int[]{0, 1, 1, 1}, 0) == 1;
        testsPassed &= countLengthOfCycle(new int[]{2, 3, 0}, 0) == 2;


        if(testsPassed) {
            System.out.println( "Test passed." );
            //return true;
        } else {
            System.out.println( "Test failed." );
            //return false;
        }


    }
}