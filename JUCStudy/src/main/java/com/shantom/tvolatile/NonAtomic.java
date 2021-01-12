package com.shantom.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class NonAtomic {
    private static volatile AtomicInteger num = new AtomicInteger(0);

    private static void increment(){
        num.incrementAndGet();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    increment();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(num);
    }
}
