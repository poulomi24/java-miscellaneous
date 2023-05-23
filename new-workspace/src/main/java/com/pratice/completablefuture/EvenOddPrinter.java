package com.pratice.completablefuture;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {
    public static Object object=new Object();
    private static IntPredicate evenCond = x -> x%2==0;
    private static IntPredicate oddCond = x -> x%2!=0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddPrinter.printNumber(oddCond));
        CompletableFuture.runAsync(() -> EvenOddPrinter.printNumber(evenCond));
        Thread.sleep(1000);
    }

    public static void printNumber(IntPredicate condition)
    {
        IntStream.rangeClosed(1,10).filter(condition).forEach(EvenOddPrinter::execute);
    }

    private static void execute(int i) {
        synchronized (object)
        {
            try {
                System.out.println(Thread.currentThread().getName()+" : "+i);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
