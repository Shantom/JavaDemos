package com.shantom.abstract1;

public class HuaweiFactory implements TechCompany{
    public Phone producePhone() {
        return new HuaweiPhone();
    }

    public Router produceRouter() {
        return new HuaweiRouter();
    }
}
