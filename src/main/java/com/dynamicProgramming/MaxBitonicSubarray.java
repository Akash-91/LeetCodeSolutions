package com.dynamicProgramming;

public class MaxBitonicSubarray {
    public static int findMaxBitonicSum(int[] arr) {
        int n = arr.length;
        int[] inc = new int[n]; // Array to store increasing subarray sums
        int[] dec = new int[n]; // Array to store decreasing subarray sums

        // Initialize inc array with the values of arr
        for (int i = 0; i < n; i++) {
            inc[i] = arr[i];
            dec[i] = arr[i];
        }

        // Find maximum increasing subarray sum
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                inc[i] = Math.max(inc[i], inc[i-1] + arr[i]);
            }
        }

        // Find maximum decreasing subarray sum
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                dec[i] = Math.max(dec[i], dec[i+1] + arr[i]);
            }
        }

        // Find the maximum bitonic subarray sum
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, inc[i] + dec[i] - arr[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 10, 20, 1};
        int result = findMaxBitonicSum(arr);
        System.out.println("Maximum Bitonic Subarray Sum: " + result);
    }
}
