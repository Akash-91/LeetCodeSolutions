package com.top150.arrays;

public class IndexOfFirstString {


    public static void main(String[] args) {


        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println(strStr(haystack, needle));

    }


    public static int strStr(String haystack, String needle) {


        if (needle.isEmpty())
            return -1;


        int[] prefix = new int[needle.length()];
        int j = 0;



        return -1;
    }
}
