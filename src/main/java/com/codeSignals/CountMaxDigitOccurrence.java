package com.codeSignals;

import java.util.*;

public class CountMaxDigitOccurrence {

    public static void main(String[] args) {
        int[] array = {98};
        array = solution(array);
        Arrays.stream(array).forEach(System.out::println);
    }


    static int[] solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxCount = 0;

        for (int i = 0; i < a.length; i++) {
            int currentNumber = a[i];
            while (currentNumber > 0) {
                int digit = currentNumber % 10; // Get the last digit

                int count =0;
                if (map.containsKey(digit)) {
                     count = (int) map.get(digit);
                    count++;
                    map.put(digit, count);

                } else {
                    count =1;
                    map.put(digit, 1);
                }
                maxCount = Math.max(maxCount, count);
                // Remove the last digit
                currentNumber /= 10;
            }
        }


        // Create a list to store digits with maximum occurrence
        List<Integer> maxOccurrenceDigits = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                maxOccurrenceDigits.add(entry.getKey());
            }
        }

        Collections.sort(maxOccurrenceDigits);

        int[] resultArray = new int[maxOccurrenceDigits.size()];
        for (int i = 0; i < maxOccurrenceDigits.size(); i++) {
            resultArray[i] = maxOccurrenceDigits.get(i);
        }

        return resultArray;
    }
}
