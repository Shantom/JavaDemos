package com.shantom.count;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Sema {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    int delay = (new Random().nextInt(3)+1)*500;
                    int permits = semaphore.availablePermits();
                    System.out.println(Thread.currentThread().getName()+"进入"+delay+"ms");
                    TimeUnit.MILLISECONDS.sleep(delay);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
