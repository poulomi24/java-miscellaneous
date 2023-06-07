package com.pratice;

import java.util.ArrayList;

public class ThreadUsingYield {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Thread addThread = new Thread(new AddThread());
        Thread removeThread = new Thread(new RemoveThread());
        addThread.start();
        removeThread.start();
    }


    static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 10; ++i) {
                list.add(i);
                System.out.println("Thread:: " + Thread.currentThread().getName() + " item added: " + i);
                Thread.yield();
            }
        }
    }

    static class RemoveThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (!list.isEmpty()) {
                    int removedElement = list.remove(0);
                    System.out.println("Removed element: " + removedElement);
                }
                Thread.yield(); // Yield execution to other threads
            }
        }
    }
}