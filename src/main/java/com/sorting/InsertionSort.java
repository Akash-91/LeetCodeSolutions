package com.sorting;

public class InsertionSort {


    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        insertionSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }


    /**
     * The insertionSort method takes an array arr as input.
     * It iterates through the array starting from the second element (index 1).
     * For each element, it saves the value in the variable key.
     * It then iterates backwards from the current index (i - 1) and shifts elements greater than key one position to the right.
     * Finally, it inserts the key at the correct position in the sorted part of the array.
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
            System.out.println("");
        }
    }
}
