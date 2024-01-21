package com.collections;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        String[] stringArray = {"A", "B", "C", "D"};
        // Convert the String array to a Stream<String>
        Stream<String> stringStream = Arrays.stream(stringArray);
        // Now you can perform operations on the stream
        stringStream.forEach(System.out::println);

        int[] intArray = {1, 2, 3, 4, 5};
        // Convert the int array to an IntStream
        IntStream intStream = Arrays.stream(intArray);
        // Now you can perform operations on the IntStream
        intStream.forEach(System.out::println);

    }
}
