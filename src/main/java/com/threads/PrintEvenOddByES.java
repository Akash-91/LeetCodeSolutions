package com.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PrintEvenOddByES {

    void printByES() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.rangeClosed(1, 10).forEach(
                num -> {
                    CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x -> {
                                if (x % 2 != 0) {
                                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + x);
                                }
                                return num;
                            }, executorService);
                    oddCompletableFuture.join();

                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x -> {
                                if (x % 2 == 0) {
                                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + x);
                                }
                                return num;
                            }, executorService);
                    evenCompletableFuture.join();
                });
        executorService.shutdown();
        System.out.println("-=-=-=-=Finished-=-=-=--=-");
    }

    void printOnlyOddByEsAndAsync() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).forEach(num -> {
            CompletableFuture.runAsync(() -> {
                if (num % 2 != 0) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + num);
                }
            }, executorService).join();
        });
        executorService.shutdown();
        System.out.println("-=-=-=-=Finished-=-=-=--=-");

    }


    void printBy2Es() {
        ExecutorService oddExecutorService = Executors.newFixedThreadPool(1);
        ExecutorService evenExecutorService = Executors.newFixedThreadPool(1);

        IntStream.rangeClosed(1, 10).forEach(num -> {
            if (num % 2 != 0) {
                CompletableFuture.runAsync(() -> {
                    System.out.println("Thread Name (Odd): " + Thread.currentThread().getName() + " : " + num);
                }, oddExecutorService).join();
            } else {
                CompletableFuture.runAsync(() -> {
                    System.out.println("Thread Name (Even): " + Thread.currentThread().getName() + " : " + num);
                }, evenExecutorService).join();
            }
        });

        oddExecutorService.shutdown();
        evenExecutorService.shutdown();

    }

    public static void main(String[] args) {

        PrintEvenOddByES printEvenOddByES = new PrintEvenOddByES();

        printEvenOddByES.printByES();
        printEvenOddByES.printOnlyOddByEsAndAsync();
        printEvenOddByES.printBy2Es();

    }
}
