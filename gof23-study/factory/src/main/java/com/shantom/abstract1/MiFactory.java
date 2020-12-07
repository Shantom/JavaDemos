package com.shantom.abstract1;

public class MiFactory implements TechCompany{
    public Phone producePhone() {
        return new MiPhone();
    }

    public Router produceRouter() {
        return new MiRouter();
    }
}
