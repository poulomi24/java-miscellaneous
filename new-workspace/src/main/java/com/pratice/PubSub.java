package com.pratice;

import java.util.ArrayList;
import java.util.List;

public class PubSub {
    private int initialCapacity =10;
    int nextInitial = 0;
    private List<Integer> list = new ArrayList<>(initialCapacity);

    public static void main(String[] args) {
        PubSub threadSignalling = new PubSub();

        Thread publisher1 = new Thread(() -> threadSignalling.publisher());
        publisher1.start();

        Thread subscriber1 = new Thread(() -> threadSignalling.subscriber());
        subscriber1.start();
    }

    public void subscriber(){
        for(int i =0 ;i<initialCapacity;i++)
        {
            synchronized (this)
            {
                try{
                    while(list.size()==0){
                        this.wait();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+nextInitial+". Message subscribed..." +list.get(0));
                    list.remove(0);
                    this.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void publisher(){
        for(int i=0;i<initialCapacity;i++)
        {
            synchronized ((this)){
                try{
                    while(list.size()==10){
                        this.wait();
                    }
                    list.add(nextInitial);
                    System.out.println(Thread.currentThread().getName()+" "+nextInitial+". Message published..." +nextInitial);
                    nextInitial++;
                    this.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
