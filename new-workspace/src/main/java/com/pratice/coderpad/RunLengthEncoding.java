package com.pratice.coderpad;

import java.util.HashMap;
import java.util.Map;

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
//        Map<Character,Integer> map = new HashMap<>();
//        for( char s : input.toCharArray())
//            map.put(s, map.getOrDefault(s,0)+1);
//        System.out.println("map:: " +map);
//        StringBuilder sb = new StringBuilder();
//        for(Map.Entry<Character, Integer> entry : map.entrySet())
//        {
//            sb.append(entry.getKey()).append(entry.getValue());
//        }
//        System.out.println("sss:  " +sb.toString());
//        return sb.toString();
        String output = "";

        for(int i =0;i<input.length();++i)
        {
            int count = 1;
            while(i< input.length()-1 && input.charAt(i)==input.charAt(i+1))
            {
                count++;
                i++;
            }
            output = output + input.charAt(i) + count;
            System.out.println(output);
        }
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
