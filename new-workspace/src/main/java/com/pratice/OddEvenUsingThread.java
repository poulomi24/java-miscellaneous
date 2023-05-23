package com.pratice;

public class OddEvenUsingThread implements Runnable{

    Object object;
    static int i=1;

    public OddEvenUsingThread(Object object)
    {
        this.object = object;
    }
    @Override
    public void run() {
        while(i<=10)
        {
            if((i%2==0) && Thread.currentThread().getName().equals("even"))
            {
                synchronized (object)
                {
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                    i++;
                    try{
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        if(i%2!=0 && Thread.currentThread().getName().equals("odd")) {
            synchronized (object)
            {
                System.out.println(Thread.currentThread().getName()+" : "+i);
                i++;
                object.notify();
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Runnable oddEvenUsingThread1 = new OddEvenUsingThread(object);
        Runnable oddEvenUsingThread2 = new OddEvenUsingThread(object);
        new Thread(oddEvenUsingThread1,"even").start();
        new Thread(oddEvenUsingThread2,"odd").start();

    }
}
