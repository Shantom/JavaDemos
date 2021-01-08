package com.shantom.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket2 {

    public static void main(String[] args) {
        final Ticket2 ticket = new Ticket2();


        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sell();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sell();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sell();
        }, "C").start();
    }
}


class Ticket2 {
    private int count = 30;
    private Lock lock = new ReentrantLock();

    public synchronized void sell(){
        lock.lock();
        try {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + count-- + "张票");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}