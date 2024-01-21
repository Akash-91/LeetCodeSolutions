package com.interviewQuestions;

import java.util.Arrays;

public class DeleteFromArray {

    public static void main(String[] args) {


        int[] originArray = {11, 22, 44, 33, 55};
        System.out.println(Arrays.toString(originArray));

   /*     int index = 3;
        removeFromIndex(originArray, index);*/


        int elementToRemove = 55;
        int[] modifiedArray = removeElement(originArray, elementToRemove);

        if (modifiedArray == null) {
            System.out.println("Element not found in the array");
        } else {
            System.out.println(Arrays.toString(modifiedArray));
        }

    }

    private static void removeFromIndex(int[] originArray, int index) {

        System.out.println("removeFromIndex " + index);
        int[] newArray = new int[originArray.length - 1];
        for (int i = 0; i < originArray.length - 1; i++) {
            if (i < index - 1)
                newArray[i] = originArray[i];
            else
                newArray[i] = originArray[i + 1];
        }
        System.out.println(Arrays.toString(newArray));

    }


    /**
     * This logic will only work if the value is present
     *
     * @param originArray
     * @param elementToRemove
     */
    private static int[] removeElement(int[] originArray, int elementToRemove) {


        int index = -1;

        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] == elementToRemove) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null; // Element not found
        }
        System.out.println("removeElement " + elementToRemove);
        int[] newArray = new int[originArray.length - 1];
        int newIndex = 0;
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] != elementToRemove) {
                newArray[newIndex] = originArray[i];
                newIndex++;
            }
        }


        return newArray;

    }
}
