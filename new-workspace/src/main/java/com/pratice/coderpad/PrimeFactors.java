package com.pratice.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactors {

    /**
     * Return an array containing prime numbers whose product is x
     * Examples:
     * primeFactorization( 6 ) == [2,3]
     * primeFactorization( 5 ) == [5]
     */
    public static List<Integer> primeFactorization(int x) {
        List<Integer> factors = new ArrayList<>();

        // Check for divisibility by 2
        while (x % 2 == 0) {
            factors.add(2);
            x = x/2;
        }

        // Check for divisibility by odd numbers
        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            while (x % i == 0) {
                factors.add(i);
                x = x/i;
            }
        }

        // If x is a prime number greater than 2
        if (x > 2) {
            factors.add(x);
        }

        return factors;
    }

    public static void main(String args[])
    {

        System.out.println(primeFactorization(6) + " " + primeFactorization(5));
        if(primeFactorization(6).equals(Arrays.asList(2,3))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
        ) {
            System.out.println("All passed");
        }else {
            System.out.println("Failed");
        }

    }
}
