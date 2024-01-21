package com.threads;

class SharedObject {
    private boolean flag = false;
    public synchronized void waitForFlag() {
        while (!flag) {
            try {
                wait(); // Waits until flag is true
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Flag is now true!");
    }

    public synchronized void setFlag() {
        flag = true;
//        notify(); // Notifies waiting threads that flag has changed
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        Thread thread1 = new Thread(() -> sharedObject.waitForFlag());

        Thread thread2 = new Thread(() -> sharedObject.setFlag());

        thread1.start();
        thread2.start();
    }
}


