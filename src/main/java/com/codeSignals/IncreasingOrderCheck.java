package com.codeSignals;

public class IncreasingOrderCheck {
    public static boolean isIncreasing(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean solution(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int num1 = numbers[i];
            int num2 = numbers[i + 1];
            char[] digits1 = Integer.toString(num1).toCharArray();
            char[] digits2 = Integer.toString(num2).toCharArray();

            // Check if swapping any two digits in num1 makes it strictly increasing
            for (int j = 0; j < digits1.length; j++) {
                for (int k = 0; k < digits2.length; k++) {
                    char temp = digits1[j];
                    digits1[j] = digits2[k];
                    digits2[k] = temp;

                    int newNum1 = Integer.parseInt(new String(digits1));
                    int newNum2 = Integer.parseInt(new String(digits2));

                    if (newNum1 < newNum2 && isIncreasing(new int[]{newNum1, newNum2})) {
                        return true;
                    }

                    // Swap back to the original state for the next iteration
                    temp = digits1[j];
                    digits1[j] = digits2[k];
                    digits2[k] = temp;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
      /*  int[] test1 = {1, 5, 10, 20};
        int[] test2 = {1, 3, 900, 10};*/
        int[] test3 = {13, 31, 30};
/*

        System.out.println(solution(test1)); // Output: true
        System.out.println(solution(test2)); // Output: true
*/
        System.out.println(solution(test3)); // Output: false
    }
}
