package com.top150.arrays;

import java.util.Arrays;

// Pointer approach
public class MergeArrays {

    public static void main(String[] args) {
        int nums1[] = {5, 6, 7, 0, 0, 0};
        int nums2[] = {2, 4, 6};
        Arrays.stream(nums1).forEach(System.out::print);
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println();
        Arrays.stream(nums1).forEach(System.out::print);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1; // Index for nums1
        int j = n - 1; // Index for nums2
        int k = m + n - 1; // Index for merged array

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // If there are remaining elements in nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
