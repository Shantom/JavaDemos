package com.shantom.service;

import com.shantom.dao.Apple;
import com.shantom.dao.IFruit;

public class FruitMarket implements IFruitMarket{
    IFruit fruit = new Apple();

    public String getOneFruit() {
        return fruit.getOne();
    }
}
