package com.top150.arrays;

public class ZigZagConversion {


    public static void main(String[] args) {

        String s = "PAYPALISHIRING";

        int rows = 4;
        System.out.println(convert(s, rows));
        String output = "PINALSIGYAHRPI";
        System.out.println(output);

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        int direction = 1; // 1 for down, -1 for up

        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0) {
                direction = 1;
            } else if (index == numRows - 1) {
                direction = -1;
            }
            index += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
