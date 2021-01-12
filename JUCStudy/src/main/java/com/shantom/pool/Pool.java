package com.shantom.pool;

import java.util.concurrent.*;

public class Pool {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            for (int i = 0; i < 9; i++) {
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            pool.shutdown();
        }

    }
}
