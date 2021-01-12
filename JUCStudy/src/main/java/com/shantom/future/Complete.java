package com.shantom.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Complete {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("completed");
            return "completed";
        }).thenApply(res -> {
            System.out.println(res + "AAA");
            return null;
        });
        future.join();
    }
}
