package com.pratice;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("inside thread t1"));
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("inside thread t2");
        });
        Thread t3 = new Thread(() ->
        {
            try{
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("inside thread t3");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

