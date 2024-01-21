package com.threads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            // Simulate another long-running task
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        // Combine the results of both futures
        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + result2);

        // Handle the result when both tasks are complete
        combinedFuture.thenAccept(result -> {
            System.out.println("Combined Result: " + result);
        });

        // Wait for the tasks to complete
        try {
            combinedFuture.get(); // This blocks until both tasks are complete
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
