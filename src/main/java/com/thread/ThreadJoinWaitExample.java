package com.thread;


class SharedObject {
    private boolean flag = false;

    // Method for thread to wait
    synchronized void waitForFlag() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " woke up");
    }

    // Method for thread to notify
    synchronized void setFlag() {
        flag = true;
        notify();
    }

    // Method for thread to notify all
    synchronized void setAllFlags() {
        flag = true;
        notifyAll();
    }
}



public class ThreadJoinWaitExample {
    public static void main(String[] args) {
        // Create a shared object
        SharedObject sharedObject = new SharedObject();

        Thread.currentThread().setName("Akash");

        // Create two threads
        Thread thread1 = new Thread(new MyThread(sharedObject, "Thread 1"));
        Thread thread2 = new Thread(new MyThread(sharedObject, "Thread 2"));

        // Start both threads
        thread1.start();
        thread2.start();

        sharedObject.setFlag();

        // Wait for both threads to finish using join
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




class MyThread implements Runnable {
    private SharedObject sharedObject;
    private String name;

    public MyThread(SharedObject sharedObject, String name) {
        this.sharedObject = sharedObject;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started");
        sharedObject.waitForFlag();
        System.out.println(name + " finished");
    }
}
