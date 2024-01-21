package com.top150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    public static void main(String[] args) {
        String s = "egd";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }


    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);


            // However, in the third iteration, we have a problem because 'o' in s is now mapped to 'a' in t,
            // and 'a' in t is already mapped to 'f' in s.
            // This violates the rule that no two characters may map to the same character.
            // Therefore, the strings are not isomorphic.

            // Check mapping from s to t
            if (sToTMapping.containsKey(charS)) {
                if (sToTMapping.get(charS) != charT) {
                    return false; // Invalid mapping
                }
            } else {
                sToTMapping.put(charS, charT);
            }

            // Check mapping from t to s
            if (tToSMapping.containsKey(charT)) {
                if (tToSMapping.get(charT) != charS) {
                    return false; // Invalid mapping
                }
            } else {
                tToSMapping.put(charT, charS);
            }
        }

        return true;
    }
}
