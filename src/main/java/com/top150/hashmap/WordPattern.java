package com.top150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String s = "abba";
        String t = "dog cat cat dog";
        System.out.println(wordPattern(s, t));
    }


    public static boolean wordPattern(String pattern, String s) {


        String[] sArray = s.split(" ");

        if (pattern.length() != sArray.length)
            return false;

        Map<Character, String> patternToSMapping = new HashMap<>();
        Map<String, Character> sToPatternMapping = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String str = sArray[i];

            // Check mapping from pattern to s
            if (patternToSMapping.containsKey(patternChar)) {
                if (!patternToSMapping.get(patternChar).equals(str)) {
                    return false; // Invalid mapping
                }
            } else {
                patternToSMapping.put(patternChar, str);
            }

            // Check mapping from s to pattern
            if (sToPatternMapping.containsKey(str)) {
                if (!sToPatternMapping.get(str).equals(patternChar)) {
                    return false; // Invalid mapping
                }
            } else {
                sToPatternMapping.put(str, patternChar);
            }
        }

        return true;
    }
}
