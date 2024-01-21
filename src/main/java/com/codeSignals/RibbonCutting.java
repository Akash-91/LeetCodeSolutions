package com.codeSignals;

import java.util.Arrays;

public class RibbonCutting {

    public static void main(String[] args) {
        int[] a1 = {5, 2, 7, 4, 9};
        int k1 = 5;
        System.out.println(solution(a1, k1)); // Output: 4

        int[] a2 = {1, 2, 3, 4, 9};
        int k2 = 6;
        System.out.println(solution(a2, k2)); // Output: 2
    }

    public static int solution(int[] a, int k) {  Arrays.sort(a);

        int left = 1;
        int right = a[a.length - 1];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (countRibbons(a, mid) >= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int countRibbons(int[] a, int length) {
        int count = 0;

        for (int ribbon : a) {
            count += ribbon / length;
        }

        return count;
    }

}
