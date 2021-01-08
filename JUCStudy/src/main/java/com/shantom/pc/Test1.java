package com.shantom.pc;

public class Test1 {

    public static void main(String[] args) {

        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}

class Data {
    private int value;

    public synchronized void increment(){
        try {
            //此处如果用if，下面notifyAll时会造成虚假唤醒，即value没有符合要求的时候被唤醒、
            //需要改成while，在被唤醒之后重新判断
            while (value!=0){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
        System.out.println(Thread.currentThread().getName()+"->"+value);
        notifyAll();
    }

    public synchronized void decrement(){
        try {
            while(value==0){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value--;
        System.out.println(Thread.currentThread().getName()+"->"+value);
        notifyAll();
    }
}