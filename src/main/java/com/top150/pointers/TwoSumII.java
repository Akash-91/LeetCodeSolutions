package com.top150.pointers;

public class TwoSumII {


    public static void main(String[] args) {

        int arr[] = {2, 3, 4};
        int target = 6;

        int result[] = twoSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int firstIndex = 0;
        int secondIndex = numbers.length - 1;

        while (firstIndex < secondIndex) {
            if (numbers[firstIndex] + numbers[secondIndex] == target)
                break;
            else if (numbers[firstIndex] + numbers[secondIndex] > target)
                secondIndex--;

            else firstIndex++;
        }

        int[] array = {firstIndex + 1, secondIndex + 1};
        return array;
    }
}
