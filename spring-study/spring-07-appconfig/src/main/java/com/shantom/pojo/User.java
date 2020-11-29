package com.shantom.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {

    @Value("雪落")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
