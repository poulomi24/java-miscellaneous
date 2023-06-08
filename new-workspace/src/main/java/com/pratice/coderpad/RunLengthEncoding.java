package com.pratice.coderpad;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 */
public class RunLengthEncoding {

    public static String rle(String input) {
        String output = "";
//        for(int i =0;i<input.length();++i)
//        {
//            int count = 1;
//            while(i< input.length()-1 && input.charAt(i)==input.charAt(i+1))
//            {
//                count++;
//                i++;
//            }
//            output = output + input.charAt(i) + count;
//            System.out.println(output);
//        }

        output = input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> entry.getKey() + String.valueOf(entry.getValue()))
                .collect(Collectors.joining());
        return output;
    }


    public static void main(String[] args)  {

        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}
