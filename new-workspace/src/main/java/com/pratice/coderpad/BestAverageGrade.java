package com.pratice.coderpad;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.

public class BestAverageGrade {

    public static Double bestAvgGrade(String[][] scores){
        return Arrays.stream(scores)
                .collect(Collectors.groupingBy(s -> s[0], Collectors.averagingDouble(s -> Double.valueOf(s[1]))))
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .getAsDouble();
    }

    public static boolean pass()
    {
        String[][] s1 = { { "Rohan", "84" },
                { "Sachin", "102" },
                { "Ishan", "55" },
                { "Sachin", "18" } };

        return bestAvgGrade(s1) == 84;
    }

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Some Fail");
        }
    }
}
