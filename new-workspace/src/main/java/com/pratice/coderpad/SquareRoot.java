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
            return Double.NaN;
        double sqrt = Math.sqrt(x);
        System.out.println("sqrt" +sqrt);
        return sqrt;
    }

    public static void main( String args[])
    {
        double[] inputs = {2, 4, 100, 0, -24};
        double[] expected_values = { 1.41421, 2, 10 ,0 , Double.NaN};
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");
    }
}
