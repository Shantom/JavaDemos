package com.shantom.simple;

public class Consumer {
    public static void main(String[] args) {
        Car wuling = CarFactory.getCar("Wuling");
        Car tesla = CarFactory.getCar("Tesla");

        wuling.name();
        tesla.name();
    }
}
