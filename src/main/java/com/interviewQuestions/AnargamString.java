package com.interviewQuestions;

import java.util.HashMap;

public class AnargamString {

    public static void main(String[] args) {


        String s = "anargam";
        String t = "naargma";

        checkStringsAreAnargam(s, t);
    }

    private static void checkStringsAreAnargam(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char a : s.toCharArray()) {
            if (map.containsKey(a)) {
                int count = map.get(a);
                map.remove(a);
                map.put(a, ++count);
            } else
                map.put(a, 1);
        }

        for (char a : t.toCharArray()) {
            if (map.containsKey(a)) {
                int count = map.get(a);
                map.put(a, --count);
            }
            if (map.containsKey(a) && map.get(a) == 0)
                map.remove(a);
        }

        System.out.println(map.isEmpty());
    }
}
