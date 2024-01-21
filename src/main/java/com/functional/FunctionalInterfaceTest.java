package com.functional;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {

        // Using a lambda expression
        Consumer<String> printConsumer = (s) -> System.out.println(s);
        printConsumer.accept("Hello, world!");

        // Using a method reference
        Consumer<String> methodRefConsumer = System.out::println;
        methodRefConsumer.accept("Hello again!");

        IntPredicate isEven = (num) -> num % 2 == 0;
        System.out.println(isEven.test(4)); // true
        IntStream.range(1, 100).filter(isEven).forEach(System.out::print);

        // Using a method reference
        Predicate<Integer> isPositive = (num) -> num > 0;
        System.out.println(isPositive.test(5)); // true

        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map.size() + " : ");
    }
}
