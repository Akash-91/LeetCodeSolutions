package com.codeSignals;

public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "aabbaa";
        System.out.println(checkPalindrome(str));
    }

    private static boolean checkPalindrome(String str) {
        char arr[] = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            if (arr[i] != arr[str.length() - 1 - i]) {
                return false; // Mismatch found, not a palindrome
            }
        }
        return true; // No mismatch found, it's a palindrome
    }
}
