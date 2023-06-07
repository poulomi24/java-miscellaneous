package com.pratice;

import java.util.concurrent.*;
import java.util.*;

public class ArrayListUsingExecutor {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Integer> list = new ArrayList<>();
        Callable addValue = () ->
        {
            for (int i = 0; i <= 10; ++i) {
                synchronized (list) {
                    list.add(i);
                    System.out.println("Inside thread:: " + Thread.currentThread().getName() + " Item added:: " + i);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return Thread.activeCount();
        };

        Callable removeValue = () -> {
            while(true)
            {
                synchronized (list)
                {
                    if(!list.isEmpty())
                    {
                        int item = list.remove(0);
                        System.out.println("Inside thread:: " + Thread.currentThread().getName() + " Item removed:: " + item);
                    }
                }
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        executorService.submit(addValue);
        executorService.submit(removeValue);
        executorService.shutdown();
    }
}
