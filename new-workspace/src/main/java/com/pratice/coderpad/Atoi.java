package com.pratice.coderpad;

public class Atoi {


    // Takes a string str and returns the int value represented by
    // the string.
    //For example, atoi("42") returns 42.

    public static int atoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            throw new IllegalArgumentException("Empty String");
        int result = str.chars()
                .reduce(0, (acc, c) ->
                {
                    if (Character.isDigit(c))
                        return acc * 10 + Character.getNumericValue(c);
                    else
                        throw new IllegalArgumentException("invalid input");
                });
        return result;
    }

    public static boolean pass() {
        boolean result = true;
        result = result && (atoi("3") == 3);
        result = result && (atoi("1") != 2);
        result = result && (atoi("4342") == 4342);

        return result;
    }

    ;

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some fail");
        }
    }
}
