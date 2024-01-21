package com.top150.pointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));



        input = "121";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
        String formatted = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = formatted.length();
        for (int i = 0; i < length / 2; i++) {
            if (formatted.charAt(i) != formatted.charAt(length -1 - i))
                return false;
        }
        return true;
    }
}
