package com.pratice.coderpad;

import java.util.stream.Collectors;

public class StringReverse {
    /**
     * public static String reverseStr( String str )
     * Example: reverseStr(str) where str is "abcd" returns "dcba".
     */
    public static String reverseStr( String str ){
       String revString = str.chars()
               .mapToObj(c -> String.valueOf((char) c))
               .reduce("", (s1, s2) -> s2 + s1);
        System.out.println("s1:: " +revString);
        return revString;
    }


    public static void main(String[] args){

        String testString;
        String solution;
        boolean result = true;

        result = result && reverseStr("abcd").equals("dcba");

        if(result){
            System.out.println("All tests pass");
        }
        else{
            System.out.println("There are test failures");
        }

    }
}
