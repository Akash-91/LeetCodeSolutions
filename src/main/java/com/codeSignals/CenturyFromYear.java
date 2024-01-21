package com.codeSignals;

public class CenturyFromYear {
    public static void main(String[] args) {
        int year = 1700;
        System.out.println(centuryFromYear(year));

    }

    private static int centuryFromYear(int year) {
        int century = (year % 100 == 0) ? year / 100 : year / 100 + 1;
        return century;
    }
}
