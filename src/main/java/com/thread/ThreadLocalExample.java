package com.thread;


class SharedCounter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}

class ThreadLocalCounter {
    private static ThreadLocal<Integer> threadLocalCount = ThreadLocal.withInitial(() -> 0);

    public static int getCount() {
        return threadLocalCount.get();
    }

    public static void increment() {
        threadLocalCount.set(threadLocalCount.get() + 1);
    }
}

public class ThreadLocalExample {
    private static SharedCounter sharedCounter = new SharedCounter();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            sharedCounter.increment();
            System.out.println("Thread 1 Count: " + sharedCounter.getCount());
        });

        Thread thread2 = new Thread(() -> {
            sharedCounter.increment();
            System.out.println("Thread 2 Count: " + sharedCounter.getCount());
        });

        thread1.start();
        thread2.start();

        //-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        Thread thread3 = new Thread(() -> {
            ThreadLocalCounter.increment();
            System.out.println("Thread 3 Count: " + ThreadLocalCounter.getCount());
        });
        Thread.sleep(2000);

        Thread thread4 = new Thread(() -> {
            ThreadLocalCounter.increment();
            System.out.println("Thread 4 Count: " + ThreadLocalCounter.getCount());
            ThreadLocalCounter.increment();
            System.out.println("Thread 4 Count: " + ThreadLocalCounter.getCount());
        });
        thread3.start();
        thread4.start();
    }
}
