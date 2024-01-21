package com.delloiteIQs;


/**
 * Least Significant beat -> 5 = 101
 */

import java.util.Arrays;
import java.util.Scanner;

public class CoronaVirus {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (N): ");
        int N = scanner.nextInt();

        // Create an array of size N
        int[] arr = new int[N];

        // Take input for the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Take input for the number of bits to shift
        System.out.print("Enter the number of bits to shift (K): ");
        int shift = scanner.nextInt();


        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int byteValue = arr[i] >> 2;
            sbf.append(byteValue);
        }

        System.out.println(N);
        System.out.println(Arrays.toString(arr));
        System.out.println(shift);
        System.out.println(sbf);
    }
}
