package com.pratice.coderpad;

public class Power {


    /* Given base and integer exponent, compute value of base raised to the power of exponent.
     * Can you implement a solution faster than O(exp)?
     */

    public static double power(double base, int exp) {
        if (exp < 0) {
            // If the exponent is negative, compute the reciprocal of the result
            return 1 / powerHelper(base, -exp);
        } else {
            return powerHelper(base, exp);
        }
    }

    private static double powerHelper(double base, int exp) {
        if (exp == 0) {
            return 1; // Any number raised to the power of 0 is 1
        } else if (exp == 1) {
            return base; // Any number raised to the power of 1 is the number itself
        } else {
            // Split the exponent into two halves
            double result = powerHelper(base, exp / 2);

            // Multiply the result by itself to get the power of exp/2
            result *= result;

            // If the exponent is odd, multiply the result by the base
            if (exp % 2 == 1) {
                result *= base;
            }

            return result;
        }
    }

    /* returns true if all tests pass, false otherwise */
    public static boolean doTestsPass() {
        return power(2,3)==8.0 &&
                power(2,1)==2.0 &&
                power(2,0)==1.0 &&
                power(2,-4) == 0.0625;
    }

    public static void main( String[] args ) {
        if (doTestsPass())
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }
}
