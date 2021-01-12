package com.shantom.lock;

import java.util.concurrent.atomic.AtomicReference;

public class Spin {
    private AtomicReference<Object> mutex = new AtomicReference<>();
    private Object object = new Object();

    public void lock(){
        while(!mutex.compareAndSet(null, object)) {      }
    }

    public void unlock(){
        mutex.compareAndSet(object, null);
    }
}
