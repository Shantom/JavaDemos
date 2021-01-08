package com.shantom.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDown {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(5);

        new Thread(()->{
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行");
        }).start();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                count.countDown();
                System.out.println(Thread.currentThread().getName()+"来了");
            }, String.valueOf(i)).start();
        }


    }


}
