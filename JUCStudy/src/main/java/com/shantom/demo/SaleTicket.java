package com.shantom.demo;

public class SaleTicket {

    public static void main(String[] args) {
        final Ticket ticket = new Ticket();


        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        },"A").start();
        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        },"B").start();
        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                ticket.sell();
            }
        },"C").start();
    }

}


class Ticket {
    private int count = 30;

    public synchronized void sell(){
        if(count>0) {
            System.out.println(Thread.currentThread().getName()+"卖出第" + count-- + "张票");
        }
    }

}