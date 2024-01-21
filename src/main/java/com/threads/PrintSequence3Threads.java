package com.threads;

class NumberPrinter implements Runnable {
    private static final int MAX_COUNT = 100;
    private static int count = 1;
    private static final Object lock = new Object();
    private int threadId;

    public NumberPrinter(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count > MAX_COUNT) {
                    break;
                }
                if (count % 3 == threadId) {
                    System.out.println(Thread.currentThread().getName() + " - " + count);
                    count++;
                }
            }
        }
    }
}


public class PrintSequence3Threads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NumberPrinter(1), "t1");
        Thread t2 = new Thread(new NumberPrinter(2), "t2");
        Thread t3 = new Thread(new NumberPrinter(0), "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}