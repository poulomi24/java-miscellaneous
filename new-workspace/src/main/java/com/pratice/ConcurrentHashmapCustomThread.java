package com.pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashmapCustomThread extends Thread{
    static Map<Integer, String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            map.put(1,"D");
        } catch (InterruptedException e) {
            System.out.println("Child thread going to add element");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        map.put(2,"A");
        map.put(3,"B");
        map.put(4,"C");

        ConcurrentHashmapCustomThread concurrentHashmapCustomThread = new ConcurrentHashmapCustomThread();
        concurrentHashmapCustomThread.start();

        for(Object o : map.entrySet())
        {
            System.out.println(o);
            Thread.sleep(1000);
        }
        System.out.println(map);
    }
}
