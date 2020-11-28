package com.shantom.singleton;

/**
 * 枚举单例无懈可击
 */
public enum EnumSingle {
    /**
     * 可直接获取
     */
    INSTANCE;

    /**
     * 也可get获取
     * @return
     */
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
