package com.top150.arrays;

import java.util.Calendar;

public class IntegerToRoman {


    int[] values;
    String[] symbols;

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();

        long start, end;

        start = Calendar.getInstance().getTimeInMillis();
        System.out.println(integerToRoman.intToRoman1(1994));
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time in milliseconds " + (end - start));


        start = Calendar.getInstance().getTimeInMillis();
        System.out.println(integerToRoman.intToRoman2(1994));
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time in milliseconds " + (end - start));

    }

    public IntegerToRoman() {
        values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    }


    public String intToRoman1(int num) {
        StringBuilder result = new StringBuilder();
        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // Repeat the symbol as many times as it fits into the number
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }

    private String intToRoman2(int num) {
        StringBuilder result = new StringBuilder();
        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            int count = num / values[i];
            num %= values[i];
            result.append(String.valueOf(symbols[i]).repeat(Math.max(0, count)));
        }
        return result.toString();
    }


}
