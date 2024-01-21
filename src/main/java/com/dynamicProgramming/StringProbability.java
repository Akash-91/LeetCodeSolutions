package com.dynamicProgramming;

import com.leetCode.arrays.Solution;

import java.util.HashSet;
import java.util.Set;

public class StringProbability {

    public static void main(String[] args) {
        String str = "aac";
        generatePermutations("", str);
        System.out.println();

        Set<String> result = new HashSet<>();
        generatePermutations2("", str, result);

        System.out.println(result);
    }

    public static void generatePermutations(String prefix, String remaining) {
        int n = remaining.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n));
            }
        }
    }

    public static void generatePermutations2(String prefix, String remaining, Set<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations2(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n),
                        result);
            }
        }
    }


}