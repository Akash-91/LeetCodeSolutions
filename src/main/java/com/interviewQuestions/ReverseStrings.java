package com.interviewQuestions;


/**
 * Hello java world
 * <p>
 * world java Hello
 */
public class ReverseStrings {

    public static void main(String[] args) {
        String original = "Hello java world";

        String result = reverse(original);
        System.out.println(result);

    }

    private static String reverse(String original) {
        StringBuffer result = new StringBuffer();

        String[] splitInput = original.split(" ");

        for (int i = splitInput.length - 1; i >= 0; i--) {
            result.append(splitInput[i]).append(" ");
        }

        return result.substring(0, result.length() - 1);
    }
}
