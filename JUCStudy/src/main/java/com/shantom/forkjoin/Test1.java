package com.shantom.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test3();
    }

    public static void test1() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println((end - start));

    }

    public static void test2() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        ForkJoinTask<Long> demo = new Demo(0L, 10_0000_0000L);
        pool.execute(demo);
        long end = System.currentTimeMillis();
        long res = demo.get();
        System.out.println(res);
        System.out.println((end - start));
    }

    public static void test3(){
        long start = System.currentTimeMillis();
        long res = LongStream.rangeClosed(0, 10_0000_0000L).sum();
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println((end - start));
    }
}

class Demo extends RecursiveTask<Long>{

    private final long start;
    private final long end;

    private final long temp = 10000L;

    public Demo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end-start < temp){
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            long middle = start + (end-start)/2;
            Demo demo1 = new Demo(start, middle);
            Demo demo2 = new Demo(middle+1, end);
            demo1.fork();
            demo2.fork();
            return demo1.join()+demo2.join();
        }
    }
}