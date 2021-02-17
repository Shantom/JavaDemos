package com.shantom;

import java.util.Random;

public class MyTest {
    private int i;

    public static void main(String[] args) {
        MyTest myTest1 = new MyTest(1);
        MyTest myTest2 = new MyTest(1);



        System.out.println(myTest1.equals(myTest2));

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public MyTest(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt();
    }

    @Override
    public boolean equals(Object obj) {

        return obj instanceof MyTest && i==((MyTest) obj).getI();
    }
}
