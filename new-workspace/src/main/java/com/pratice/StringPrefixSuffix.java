package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringPrefixSuffix {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",","**","**");
        stringJoiner.add("Poulomi");
        stringJoiner.add("Mandal");
        System.out.println("the new string is:: " +stringJoiner);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        String intString = integerList.stream().map(i -> i.toString()).collect(Collectors.joining(","));
        System.out.println("intString = " +intString);
    }
}
