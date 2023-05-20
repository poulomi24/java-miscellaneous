package com.pratice;

public class ObjectLevelLock implements Runnable{

    @Override
    public void run() {

    }
    public void Lock(){
        System.out.println(Thread.currentThread().getName());
        synchronized (ObjectLevelLock.class)
        {
            System.out.println("in block " +Thread.currentThread().getName());
            System.out.println("in block" +Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ObjectLevelLock objectLevelLock = new ObjectLevelLock();
        Thread t1 = new Thread(objectLevelLock);
        Thread t2 = new Thread(objectLevelLock);
        ObjectLevelLock objectLevelLock1 = new ObjectLevelLock();
        Thread t3 = new Thread(objectLevelLock1);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
