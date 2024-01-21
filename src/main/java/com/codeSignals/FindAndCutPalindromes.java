package com.codeSignals;

import java.util.Calendar;

public class FindAndCutPalindromes {
    public static void main(String[] args) {


        long start = Calendar.getInstance().getTimeInMillis();
        String s = "aaacodedoc";
        System.out.println(solution(s));
        s = "codeSignal";
        System.out.println(solution(s));
        s = "codedocSignal";
        System.out.println(solution(s));
        s = "a";
        System.out.println(solution(s));
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken by Solution 1 is: " + (end - start));


        start = Calendar.getInstance().getTimeInMillis();
        s = "aaacodedoc";
        System.out.println(solution2(s));
        s = "codeSignal";
        System.out.println(solution2(s));
        s = "codedocSignal";
        System.out.println(solution2(s));
        s = "a";
        System.out.println(solution2(s));
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken by Solution 2 is: " + (end - start));

    }

    public static String solution(String s) {
        while (s.length() > 0) {
            String longestPalindrome = findLongestPalindrome(s);

            if (longestPalindrome.length() >= 2) {
                s = s.replaceFirst(longestPalindrome, "");
            } else {
                break;
            }
        }
        return s;
    }

    public static String solution2(String s) {
        while (s.length() > 0) {
            String longestPalindrome = findLongestPalindrome2(s);

            if (longestPalindrome.length() >= 2) {
                s = s.replaceFirst(longestPalindrome, "");
            } else {
                break;
            }
        }
        return s;
    }


    private static String findLongestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        String longestPalindrome = s.substring(0, 1);

        for (int length = 2; length <= n; length++) {
            for (int start = 0; start <= n - length; start++) {
                int end = start + length - 1;

                if (length == 2 && s.charAt(start) == s.charAt(end)) {
                    isPalindrome[start][end] = true;
                } else if (s.charAt(start) == s.charAt(end) && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                }

                if (isPalindrome[start][end] && length > longestPalindrome.length()) {
                    longestPalindrome = s.substring(start, end + 1);
                }
            }
        }

        return longestPalindrome;
    }


    private static String findLongestPalindrome2(String s) {
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


}
