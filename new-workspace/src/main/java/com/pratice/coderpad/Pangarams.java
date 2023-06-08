package com.pratice.coderpad;


/**
 * Pangram FInder
 * <p>
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing
 */
public class Pangarams {


    private static class PanagramDetector {
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        //your code goes here
        public String findMissingLetters(String sentence) {
            String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
            if(sentence.isEmpty())
                return ALPHABETS;
//            String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
//            sentence = sentence.toLowerCase();
//            for (int i = 0; i < sentence.length(); i++) {
//                int index = ALPHABETS.indexOf(sentence.charAt(i));
//                if (index != -1) {
//                    ALPHABETS = ALPHABETS.substring(0, index) + ALPHABETS.substring(index + 1);
//                }
//                System.out.println(ALPHABETS);
//            }
//            System.out.println("SS:: " +ALPHABETS);
//            return ALPHABETS;
            boolean[] letters = new boolean[26];
            sentence = sentence.toLowerCase();

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                if (Character.isLetter(ch)) {
                    int index = ch - 'a';
                    letters[index] = true;
                }
            }

            StringBuilder missingLetters = new StringBuilder();
            for (int i = 0; i < letters.length; i++) {
                if (!letters[i]) {
                    char missingLetter = (char) ('a' + i);
                    missingLetters.append(missingLetter);
                }
            }

            return missingLetters.toString();
        }

        public static void main(String[] args) {
            PanagramDetector pd = new PanagramDetector();
            boolean success = true;

            success = success && "lq".equals(pd.findMissingLetters("The uick brown fox jumps over the azy dog"));
            success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

            if (success) {
                System.out.println("Pass ");
            } else {
                System.out.println("Failed");
            }
        }
    }
}
