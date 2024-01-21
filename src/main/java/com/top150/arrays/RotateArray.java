package com.top150.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6};
        int k = 2;
        // expected = {5, 6, 1, 2, 3, 4 };
        rotate(nums, k);
        Arrays.stream(nums).forEach(value -> System.out.print(value + " "));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // Handle the case where k is larger than the array size
        k = k % n;

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
