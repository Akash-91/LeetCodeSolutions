package com.dynamicProgramming;

public class StringSum {


    public static void main(String[] args) {

        String s = "1234";
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = Character.getNumericValue(c);
            sum += digit;
        }

        System.out.println("Sum of digits: " + sum);
    }
}
