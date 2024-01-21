package com.top150.math;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        int number = 300;
        System.out.println(trailingZeroes(number));
    }


    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
