package com.pratice.coderpad;
import java.lang.Math;

public class SquareRoot {
    /*
     *   double squareRoot( double x )
     *
     */

    public static double squareRoot( double x )
    {
        if(x<0)
            throw new IllegalArgumentException("unable to calculate root of a negative number");
        double sqrt = Math.sqrt(x);
        System.out.println("sqrt" +sqrt);
        return sqrt;
    }

    public static double calculateSquareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }

        double low = 0;
        double high = number;
        double precision = 1e-15; // Set a small precision

        while (high - low > precision) {
            double mid = (low + high) / 2;
            double square = mid * mid;

            if (square == number) {
                return mid;
            } else if (square < number) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2;
    }
    public static void main( String args[])
    {
        double[] inputs = {2, 4, 100, 0};
        double[] expected_values = { 1.41421, 2, 10 ,0};
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(calculateSquareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], calculateSquareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");
    }
}
