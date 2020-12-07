package com.shantom.abstract1;

public class Client {
    public static void main(String[] args) {
        TechCompany xiaomi = new MiFactory();
        TechCompany huawei = new HuaweiFactory();

        Phone miPhone = xiaomi.producePhone();
        Router miRouter = xiaomi.produceRouter();

        miPhone.call();
        miRouter.route();

        Phone huaweiPhone = huawei.producePhone();
        Router huaweiRouter = huawei.produceRouter();

        huaweiPhone.call();
        huaweiRouter.route();
    }
}
