package com.shantom.lock;

public class TestSpinLock {
    public static void main(String[] args) {
        Data data = new Data();

        for (int i = 0; i < 40; i++) {
            new Thread(()->{
                data.sell();
            }).start();
        }
    }
}

class Data{
    private int num = 30;
    Spin lock = new Spin();

    public void sell(){
        lock.lock();
        if(num>0){
            num--;
            System.out.println("sold, rest "+ num);
        }
        lock.unlock();
    }
}