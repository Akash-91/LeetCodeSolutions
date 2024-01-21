package com.top150.math;

public class Power {

    public static void main(String[] args) {

        double x = 2;
        int n = 8;

        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double result = 1.0;
        long absN = Math.abs((long) n);

        while (absN > 0) {
            if (absN % 2 == 1) {
                result *= x;
            }
            x *= x;
            absN /= 2;
        }

        return n < 0 ? 1 / result : result;
    }


    public static double formatWithPrecision(double value, int precision) {
        String formatString = "%." + precision + "f";
        String formattedValue = String.format(formatString, value);
        return Double.parseDouble(formattedValue);
    }
}
