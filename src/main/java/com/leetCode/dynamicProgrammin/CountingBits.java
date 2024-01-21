package com.leetCode.dynamicProgrammin;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class CountingBits {

    public static void main(String[] args) {

        int n = 5;
        int arr[] = countBits(n);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        arr = countOnes(n);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] countOnes(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }

    private static int[] countBits(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            int ones = 0;
            char charArr[] = s.toCharArray();
            for (char c : charArr) {
                if (c == '1')
                    ones++;
            }
            arr[i] = ones;
        }
        return arr;

    }
}
