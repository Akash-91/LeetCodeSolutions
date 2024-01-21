package com.top150.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {


    public static void main(String[] args) {


        String s = "a";
        String t = "ab";


        System.out.println(isAnagram(s, t));
    }


    public static boolean isAnagram(String s, String t) {
        // Check if the lengths of the two strings are equal
        if (s.length() != t.length()) {
            return false;
        }

        // Convert the strings to char arrays and sort them
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);

        // Compare the sorted char arrays
        return Arrays.equals(charArrayS, charArrayT);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {

            if (characterIntegerMap.containsKey(t.charAt(i))) {
                int count = characterIntegerMap.get(t.charAt(i));
                characterIntegerMap.put(t.charAt(i), ++count);
            } else
                characterIntegerMap.put(t.charAt(i), 1);
        }


        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (characterIntegerMap.containsKey(currentChar)) {
                int count = characterIntegerMap.get(currentChar);
                if (count == 0) {
                    return false;
                } else {
                    characterIntegerMap.put(currentChar, --count);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
