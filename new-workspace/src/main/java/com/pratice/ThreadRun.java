package com.pratice;

public class ThreadRun {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread is running:: " + i);
        }
    }
}
