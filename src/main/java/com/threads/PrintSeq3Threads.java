package com.threads;


class Print {
    private int num = 1;
    int max;

    public Print(int max) {
        this.max = max;
    }

    public synchronized void printNumber(int remainder) {
        while (num < max - 1) {
            while (num % 2 != remainder) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + num);
            num++;
            notifyAll();

        }
    }
}

class PrintSequence1 implements Runnable {
    private final Print printer;

    public PrintSequence1(Print printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumber(0);
    }
}

class PrintSequence2 implements Runnable {

    private final Print printer;

    public PrintSequence2(Print printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumber(1);
    }
}

class PrintSequence3 implements Runnable {
    private final Print printer;

    public PrintSequence3(Print printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumber(2);
    }
}

public class PrintSeq3Threads {

    public static void main(String[] args) {

        Print print = new Print(20);
        Thread thread1 = new Thread(new PrintSequence1(print), "Thread-1");
        Thread thread2 = new Thread(new PrintSequence2(print), "Thread-2");
         Thread thread3 = new Thread(new PrintSequence3(print), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
