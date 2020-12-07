package com.shantom;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    public Object call() throws Exception {
        System.out.println("MyCallable 在运行");
        return null;
    }

    public static void main(String[] args) {
    }
}
