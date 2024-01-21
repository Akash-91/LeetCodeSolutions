package com.top150.math;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindromeString(String.valueOf(x)));

        System.out.println(isPalindrome(x));

    }

    public static boolean isPalindrome(int x) {
        int reverseNumber = 0;
        int temp = x;
        while (temp > 0) {
            reverseNumber = reverseNumber * 10 + temp % 10;
            temp = temp / 10;
        }
        return reverseNumber == x;
    }

    public static boolean isPalindromeString(String formatted) {
        int length = formatted.length();
        for (int i = 0; i < length / 2; i++) {
            if (formatted.charAt(i) != formatted.charAt(length - 1 - i))
                return false;
        }
        return true;
    }
}
