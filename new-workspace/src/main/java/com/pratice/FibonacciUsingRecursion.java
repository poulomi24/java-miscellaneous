package com.pratice;

public class FibonacciUsingRecursion {
    private static int a = 0, b = 1, c;

    public static void main(String[] args) {
        printFibo(10);
    }

    static void printFibo(int n) {
        if (n >= 1) {
            System.out.println(" " + c);
            c = a + b;
            a = b;
            b = c;
            printFibo(n - 1);
        }
    }
}
