package com.pratice;

public class StringObject {
    public static void main(String[] args) {
        String s1 = new String("Poulomi");
        String s2 = "Poulomi";
        //2 objects...one at heap using new and the other one at SCP
        //for string s2, it will point to the one at SCP
        System.out.println(s1.intern());
        System.out.println(s1.intern().hashCode()==s2.hashCode());
    }
}
