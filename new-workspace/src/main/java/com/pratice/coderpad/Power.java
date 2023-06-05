package com.pratice.coderpad;

public class Power {


    /* Given base and integer exponent, compute value of base raised to the power of exponent.
     * Can you implement a solution faster than O(exp)?
     */

    public static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        } else if (exp < 0) {
            return 1 / power(base, -exp);
        } else if (exp % 2 == 0) {
            double halfPower = power(base, exp / 2);
            return halfPower * halfPower;
        } else {
            double halfPower = power(base, exp / 2);
            return halfPower * halfPower * base;
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
