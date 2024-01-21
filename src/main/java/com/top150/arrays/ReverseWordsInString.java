package com.top150.arrays;

public class ReverseWordsInString {


    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

        s = "  hello world  ";
        System.out.println(reverseWords(s));

        s = "a good   example";
        System.out.println(reverseWords(s));

    }


    public static String reverseWords(String s) {
        s = s.trim();
        String str[] = s.split(" ");
        StringBuffer sbf = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {

            if (!str[i].trim().equals(""))
                sbf.append(str[i].trim()).append(" ");
        }
        return sbf.toString().trim();
    }
}
