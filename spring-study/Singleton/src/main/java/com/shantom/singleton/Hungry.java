package com.shantom.singleton;

/**
 * 饿汉式，程序启动时即创建
 */
public class Hungry {
    // 非常浪费空间
    private byte[] data= new byte[1024*1024*10];

    private Hungry(){}

    private static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){return HUNGRY;}
}
