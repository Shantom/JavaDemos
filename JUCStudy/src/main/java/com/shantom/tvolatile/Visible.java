package com.shantom.tvolatile;

import java.util.concurrent.TimeUnit;

public class Visible {
    // volatile
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){

            }
            System.out.println("num的修改被感知");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num = 1;
        System.out.println("num="+num);
    }
}
