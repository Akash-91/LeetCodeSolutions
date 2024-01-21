package com.threads;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {
    private static Object object = new Object();
    private static IntPredicate even = e -> e % 2 == 0;
    private static IntPredicate odd = e -> e % 2 != 0;

    public static void printResult(IntPredicate condition) {
        IntStream.rangeClosed(1, 100).filter(condition).forEach(EvenOddPrinter::execute); // method reference
    }

    public static void execute(int i) {
        synchronized (object) {
            try {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + i);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddPrinter.printResult(even));
        CompletableFuture.runAsync(() -> EvenOddPrinter.printResult(odd));
        Thread.sleep(1000);
    }
}
