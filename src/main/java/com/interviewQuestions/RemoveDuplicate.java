package com.interviewQuestions;

import java.util.HashSet;

public class RemoveDuplicate {


    public static void main(String[] args) {
        String str = "akash anshu alaina";
        String result = removeDuplicate(str);
        System.out.println(result);
    }

    private static String removeDuplicate(String str) {
        HashSet<Character> set = new HashSet<>();
        StringBuffer result = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                result.append(c);
                set.add(c);
            }
        }
        return result.toString();
    }
}
