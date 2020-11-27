package com.shantom.service;

import com.shantom.dao.AppleSeller;
import com.shantom.dao.IFruitSeller;

public class FruitMarket implements IFruitMarket{
    IFruitSeller fruitSeller = new AppleSeller();

    public void setFruitSeller(IFruitSeller fruitSeller) {
        this.fruitSeller = fruitSeller;
    }

    public String getOneFruit() {
        return fruitSeller.buyOne();
    }
}
