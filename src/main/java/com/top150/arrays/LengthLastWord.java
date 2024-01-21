package com.top150.arrays;

public class LengthLastWord {
    public static void main(String[] args) {

        String s = " a";
        System.out.println(lengthOfLastWord(s));
    }


    public static int lengthOfLastWord(String s) {
        String lastWord;
        String words = s.trim();
        if (words.contains(" ")) {
            lastWord = words.substring(words.lastIndexOf(" "));
            return lastWord.length()-1;
        }
        return words.length();
    }
}
