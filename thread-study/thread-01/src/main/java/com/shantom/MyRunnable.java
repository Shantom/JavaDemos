package com.shantom;

public class MyRunnable implements Runnable{
    public void run() {
        System.out.println("MyRunnable 在运行");
    }

    public static void main(String[] args) {
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();
    }
}
