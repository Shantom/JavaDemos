package com.shantom.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * 懒汉式
 * 线程安全
 * 但可被反射破坏
 */
public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName());
    }

    private volatile static LazyMan lazyMan;

    /**
     * 线程不安全
     * @return
     */
//    public static LazyMan getInstance(){
//        if(lazyMan==null){
//            lazyMan = new LazyMan();
//        }
//        return lazyMan;
//    }

    /**
     * 双重检测懒汉式Double Check Lazy (DCL)，必须将对象设为volatile，避免指令重排
     * 构造对象共三部，23部可重排
     * 1. 申请内存空间
     * 2. 构造对象
     * 3. 将指针指向该内存空间
     * @return
     */
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    @Test
    public void testT() {
        for (int i = 0; i < 40; i++) {
            new Thread(()->{
                if(LazyMan.getInstance()==null){
                    System.out.println("null");
                }
            }).start();
        }
    }

    @Test
    public void testR() throws Exception {
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }

}
