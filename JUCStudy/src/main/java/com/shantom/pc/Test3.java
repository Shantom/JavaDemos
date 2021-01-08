package com.shantom.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {

    public static void main(String[] args) {

        Data3 data = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.first();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.second();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.third();
            }
        }, "C").start();

    }
}

class Data3 {
    private int value;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void first(){
        lock.lock();
        try {
            while (value!=0){
                condition1.await();
            }
            value=1;
            System.out.println(Thread.currentThread().getName()+"->"+value);
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void second(){
        lock.lock();
        try {
            while(value!=1){
                condition2.await();
            }
            value=2;
            System.out.println(Thread.currentThread().getName()+"->"+value);
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void third(){
        lock.lock();
        try {
            while(value!=2){
                condition3.await();
            }
            value=0;
            System.out.println(Thread.currentThread().getName()+"->"+value);
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}