package com.top150.bitmanipulation;

import java.math.BigInteger;

public class AddBinary {


    public static void main(String[] args) {
        String a = "1100", b = "101";
        System.out.println(addBinary(a, b));
    }


    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = bitA + bitB + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        return sb.toString();
    }
}
