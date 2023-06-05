package com.pratice.coderpad;

import java.util.*;

public class GroupAnagram {
    static String input = "cat dog tac sat tas god dog";

    void setOfAnagrams(String inputString){
        String[] strs = inputString.split(" ");
        if(strs==null || strs.length==0)
            System.out.println("no anagrams");
        Map<String, List<String>> stringMap = new HashMap<>();
        for(String s : strs)
        {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);

            if(!stringMap.containsKey(key))
                stringMap.put(key, new ArrayList<>());
            stringMap.get(key).add(s);
        }
        List<List<String>> resultList = new ArrayList<>();
        for(Map.Entry<String, List<String>> stringAnagrams : stringMap.entrySet())
            resultList.add(stringAnagrams.getValue());
        System.out.println(resultList);
        Collections.sort(resultList, new ListComparator<>());
        System.out.println(resultList);
    }


    public static void main(String[] args) {
        GroupAnagram groupAnagram= new GroupAnagram();
        String input = "cat dog tac sat tas god dog";
        groupAnagram.setOfAnagrams(input);

    }
    class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        }

    }
}
