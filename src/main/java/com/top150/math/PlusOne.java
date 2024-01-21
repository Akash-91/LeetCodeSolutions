package com.top150.math;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {


        int[] digits = {1,9};

        Arrays.stream(plusOne(digits)).forEach(System.out::print);

    }


    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

// If there is still a carry, add a new digit to the left
        if (carry > 0) {
            int[] result = new int[n + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        } else {
            return digits;
        }
    }
}
