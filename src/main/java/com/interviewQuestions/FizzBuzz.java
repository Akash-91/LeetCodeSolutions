package com.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }


        for (String s : result) {
            System.out.print(s);
        }

    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 5;
        int n3 = 15;

        FizzBuzz.fizzBuzz(n1);
        System.out.println();

        FizzBuzz.fizzBuzz(n2);
        System.out.println();

        FizzBuzz.fizzBuzz(n3);

    }
}
