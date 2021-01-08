package com.shantom.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    public static void main(String[] args) {

        Data2 data = new Data2();

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

class Data2 {
    private int value;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            //此处如果用if，下面notifyAll时会造成虚假唤醒，即value没有符合要求的时候被唤醒、
            //需要改成while，在被唤醒之后重新判断
            while (value!=0){
                condition.await();
            }
            value++;
            System.out.println(Thread.currentThread().getName()+"->"+value);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while(value==0){
                condition.await();
            }
            value--;
            System.out.println(Thread.currentThread().getName()+"->"+value);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}