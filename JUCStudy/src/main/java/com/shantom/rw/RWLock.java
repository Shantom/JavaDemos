package com.shantom.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLock {

    public static void main(String[] args) {

        MyCacheLock myCache = new MyCacheLock();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.write(String.valueOf(finalI), String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.read(String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }
    }

}

class MyCacheLock{
    private volatile Map<String, String> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public String read(String key){
        lock.readLock().lock();
        String value = null;
        try {
            System.out.println(Thread.currentThread().getName()+"read start");
            value = map.get(key);
            System.out.println(Thread.currentThread().getName()+"read end:"+value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return value;
    }

    public void write(String key, String value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"write start");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"write end");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
class MyCache{
    private volatile Map<String, String> map = new HashMap<>();

    public String read(String key){
        System.out.println(Thread.currentThread().getName()+"read start");
        String value = map.get(key);
        System.out.println(Thread.currentThread().getName()+"read end:"+value);
        return value;
    }

    public void write(String key, String value){
        System.out.println(Thread.currentThread().getName()+"write start");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"write end");
    }
}