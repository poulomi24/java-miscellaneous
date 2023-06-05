package com.pratice.coderpad;

public class MagicPotion {

    private static int minimalSteps(String ingredients) {
        int count = 1;
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(ingredients.charAt(0));
        while (i < ingredients.length()) {
            if (ingredients.length() >= 2 * i && ingredients.charAt(i) == ingredients.charAt(0)) {
                if (ingredients.substring(0, i).equals(ingredients.substring(i, 2 * i))) {
                    i += i - 1;
                    sb.append("*");
                } else
                    sb.append(ingredients.charAt(i));
            } else {
                sb.append(ingredients.charAt(i));
            }
            count++;
            i++;
        }
        System.out.println(sb.toString());
        return count;
    }

//    private boolean doTestsPass() {
//        return false;
//    }

    public static void main(String[] args) {

        if (minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
