package com.pratice.coderpad;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApacheLog {

    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */

    public static String findTopIpaddress(String[] lines) {
//        Map<String,Integer> map = new HashMap<>();
//
//        for(String s : lines)
//        {
//            String ip = s.split(" - ")[0];
//            map.put(ip, map.getOrDefault(ip,0)+1);
//        }
//        System.out.println("map:: " +map);
//        int count = 0;
//        String ipMax = null;
//        for(Map.Entry<String, Integer> entry : map.entrySet())
//        {
//         String ip = entry.getKey();
//         int cp = entry.getValue();
//         if(cp > count)
//         {
//             count = cp;
//             ipMax = ip;
//         }
//
//        }
//        System.out.println("ipmax: " +ipMax);
//        // Your code goes here
//        return ipMax;

        String topIpAddress = Arrays.stream(lines)
                .map(line -> line.split(" - ")[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return topIpAddress;
    }


//    public static boolean doTestsPass() {
//
//
//    }

    public static void main(String[] args) {

        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }
}
