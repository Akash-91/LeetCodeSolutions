package com.codeSignals;

import java.util.Arrays;
import java.util.Calendar;

public class FindAndCutPalindromes2 {
    public static String solution(String s) {
        StringBuilder result = new StringBuilder();

        while (s.length() > 0) {
            String longestPalindrome = findLongestPalindrome(s);

            if (longestPalindrome.length() >= 2) {
                result.append(s, 0, s.indexOf(longestPalindrome)).append(s, s.indexOf(longestPalindrome) + longestPalindrome.length(), s.length());
                s = result.toString();
                result.setLength(0);
            } else {
                break;
            }
        }
        return s;
    }

    private static String findLongestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && substring.length() > longestPalindrome.length()) {
                    longestPalindrome = substring;
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage:
        long start = Calendar.getInstance().getTimeInMillis();
        System.out.println(solution("aaacodedoc")); // Output: ""
        System.out.println(solution("codesignal")); // Output: "codesignal"
        System.out.println(solution("")); // Output: ""

        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken by Solution 1 is: " + (end - start));
    }
}
