package com.threads;

class SharedPrinter {
    private volatile int num = 1;
    private int max;

    public SharedPrinter(int max) {
        this.max = max;
    }

    public synchronized void printNumber(int remainder) {
        while (num < max - 1) {
            while (num % 2 != remainder) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + num);
            num++;
            notifyAll();
        }
    }
}

class OddNumberPrinter implements Runnable {
    private final SharedPrinter printer;

    public OddNumberPrinter(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumber(1);
    }
}

class EvenNumberPrinter implements Runnable {
    private final SharedPrinter printer;

    public EvenNumberPrinter(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumber(0);
    }
}

public class PrintEvenOddVolatilevar {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter(10);
        Thread t1 = new Thread(new OddNumberPrinter(printer), "Thread-1");
        Thread t2 = new Thread(new EvenNumberPrinter(printer), "Thread-2");

        t1.start();
        t2.start();
    }
}
