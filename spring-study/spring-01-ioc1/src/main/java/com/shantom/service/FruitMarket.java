package com.shantom.service;

import com.shantom.dao.AppleProvider;
import com.shantom.dao.IFruitProvider;

public class FruitMarket implements IFruitMarket{
    IFruitProvider fruitProvider = new AppleProvider();

    public void setFruitProvider(IFruitProvider fruitProvider) {
        this.fruitProvider = fruitProvider;
    }

    public String getOneFruit() {
        return fruitProvider.getOne();
    }
}
