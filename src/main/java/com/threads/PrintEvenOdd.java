package com.threads;

public class PrintEvenOdd implements Runnable {
    static int count = 1;
    Object object;

    public PrintEvenOdd(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (count <= 100) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("Even")) {
                synchronized (object) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " value :" + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (count % 2 != 0 && Thread.currentThread().getName().equals("Odd")) {
                synchronized (object) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " value :" + count);
                    count++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {

        Object lock = new Object();
        Runnable r1 = new PrintEvenOdd(lock);
        Runnable r2 = new PrintEvenOdd(lock);

        new Thread(r1, "Even").start();
        new Thread(r2, "Odd").start();
        System.out.println("Done");
    }
}
