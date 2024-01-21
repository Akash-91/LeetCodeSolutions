package com.codeSignals;

import java.util.Calendar;

public class ConcatenatedNumberSum {


    public static void main(String[] args) {
        int[] array = {10, 2, 3, 56, 54};

        long start, end;

        start = Calendar.getInstance().getTimeInMillis();
        long sum = solution(array);
        System.out.println(sum);
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time in milliseconds " + (end - start));


        start = Calendar.getInstance().getTimeInMillis();
        sum = solution2(array);
        System.out.println(sum);
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time in milliseconds " + (end - start));

        start = Calendar.getInstance().getTimeInMillis();
        sum = solution3(array);
        System.out.println(sum);
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time in milliseconds " + (end - start));

    }

    private static long solution(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                String number = String.valueOf(array[i]) + String.valueOf(array[j]);
                long finalNumber = Long.parseLong(number);
                sum += finalNumber;
            }
        }
        return sum;
    }


    private static long solution2(int[] array) {
        long sum = 0;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            sum += currentNumber * Math.pow(10, countDigits(array)) * sumArray(array);
        }

        return sum;
    }

    // Helper method to count the total number of digits in the array
    private static int countDigits(int[] array) {
        int count = 0;
        for (int num : array) {
            count += String.valueOf(num).length();
        }
        return count;
    }

    // Helper method to calculate the sum of all elements in the array
    private static long sumArray(int[] array) {
        long sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }


    private static long solution3(int[] array) {
        long sum = 0;
        int totalDigitCount = countDigits(array);
        long arraySum = sumArray(array);

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            sum += currentNumber * Math.pow(10, totalDigitCount - 1) * arraySum;
        }

        return sum;
    }


}