package com.pratice.coderpad;

import java.util.*;

public class DictionaryMain {
    public static Set<String> longestWord(String letters, Dictionary dict) {
        Set<String> result = new HashSet<String>();
        int maxLength = 0;
        for (String word : dict.entries) {
            if (isWordPossible(word, letters) && word.length() >= maxLength) {
                if (word.length() > maxLength) {
                    result.clear();
                    maxLength = word.length();
                }
                result.add(word);
            }
        }

        return result;
    }

    private static boolean isWordPossible(String word, String letters) {
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char c : letters.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        for (char c : word.toCharArray()) {
            if (!letterCount.containsKey(c) || letterCount.get(c) == 0) {
                return false;
            }
            letterCount.put(c, letterCount.get(c) - 1);
        }

        return true;
    }



    public static boolean pass() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
        boolean r = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        return r;
    }

    public static void main(String[] args) {
        if(pass()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }
    static class Dictionary {
        private String[] entries;

        public Dictionary(String[] entries) {
            this.entries = entries;
        }

        public boolean contains(String word) {
            return Arrays.asList(entries).contains(word);
        }
    }
}
