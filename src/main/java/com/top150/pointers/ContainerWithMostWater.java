package com.top150.pointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int array[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(array));
    }

    public static int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int currentWater = (right - left) * Math.min(height[left], height[right]);
            if (height[left] < height[right]) {
                left++;
            } else
                right--;
            maxWater = Math.max(maxWater, currentWater);
        }
        return maxWater;
    }
}
