package com.pratice.coderpad;

public class AddFraction {
    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */
    public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
        // Write your code here
        int numerator1 = fraction1[0];
        int denominator1 = fraction1[1];
        int numerator2 = fraction2[0];
        int denominator2 = fraction2[1];

        // Find the least common multiple (LCM) of the denominators
        int lcm = findLCM(denominator1, denominator2);

        // Multiply each numerator by the LCM divided by its corresponding denominator
        int newNumerator1 = numerator1 * (lcm / denominator1);
        int newNumerator2 = numerator2 * (lcm / denominator2);

        // Add the numerators together
        int sumNumerator = newNumerator1 + newNumerator2;

        // Find the greatest common divisor (GCD) of the numerator and denominator
        int gcd = findGCD(sumNumerator, lcm);

        // Simplify the resulting fraction
        int simplifiedNumerator = sumNumerator / gcd;
        int simplifiedDenominator = lcm / gcd;

        int[] result = {simplifiedNumerator, simplifiedDenominator};
        return result;
    }
    // Helper method to find the least common multiple (LCM)
    private static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    // Helper method to find the greatest common divisor (GCD) using Euclid's algorithm
    private static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }


    public static void main( String[] args ) {
        int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

        if( result[ 0 ] == 7 && result[ 1 ] == 6 ) {
            System.out.println( "Test passed." );
        } else {
            System.out.println( "Test failed." );
        }
    }
}
