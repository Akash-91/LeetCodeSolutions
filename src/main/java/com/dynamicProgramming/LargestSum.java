package com.dynamicProgramming;


/**
 * You are given an array of integers. The problem statement asks to find out the largest sum contiguous subarray.
 * This means nothing but to find a subarray (continuous elements) which has the largest sum among all other subarrays in the given array.
 * <p>
 * Example
 * arr[] = {1, -3, 4, -2, 5, -6, 2}
 * [2, 4]
 */
public class LargestSum {


    public static void main(String[] args) {
        int arr[] = {1, -3, 4, -2, 5, -6, 2};

        int n = arr.length;
        getLargestSumContiguousSubarray(arr, n);

        arr = new int[]{-10, -2, 5, 4, 10, -20, -1};
        n = arr.length;
        getLargestSumContiguousSubarray(arr, n);
    }

    private static void getLargestSumContiguousSubarray(int[] arr, int n) {
        int maxValue = Integer.MIN_VALUE;
        int start = 0, end = 0, s = 0, maxPoint = 0;

        for (int i = 0; i < arr.length; i++) {
            maxPoint += arr[i];
            if (maxValue < maxPoint) {
                maxValue = maxPoint;
                start = s;
                end = i;
            }
            if (maxPoint < 0) {
                maxPoint = 0; // start a new sub arrays sum again
                s = i + 1; // move the starting point of sub array ahead as till now the values summed up to 0
            }
        }
        System.out.println("Sub array starting from " + start + " to " + end + " has a largest sum of " + maxValue);
    }


}
