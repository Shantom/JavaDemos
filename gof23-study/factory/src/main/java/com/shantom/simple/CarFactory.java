package com.shantom.simple;

import com.sun.istack.internal.NotNull;

public class CarFactory {
    public static Car getCar(@NotNull String type){
        if("Wuling".equals(type)){
            return new Wuling();
        }else if("Tesla".equals(type)){
            return new Tesla();
        }else {
            return null;
        }
    }
}
