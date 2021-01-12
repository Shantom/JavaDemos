package com.shantom.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable = new MyThread();
        FutureTask<String> future = new FutureTask<>(callable);
        new Thread(future, "A").start();
        new Thread(future, "B").start();

        TimeUnit.SECONDS.sleep(1);
        String s = future.get();
        System.out.println(s);
    }
}


class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyThread call()");
        return Thread.currentThread().getName();
    }
}