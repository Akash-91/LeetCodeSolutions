package com.leetCode.assessment;

public class ReverseInteger {

    public int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            int pop = x % 10;
            reversed = reversed * 10 + pop;

            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversed;
    }

    public static void main(String[] args) {


        System.out.println(new ReverseInteger().reverse( 2147483646));
    }
}
