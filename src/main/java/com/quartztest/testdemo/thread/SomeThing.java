package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 16:43
 */
public enum SomeThing{
    INSTANCE;
    private EnumSingleton enumSingleton;
    SomeThing() {
        enumSingleton = new EnumSingleton();
        System.out.println("something 实例化");
    }
    public EnumSingleton getInstance() {
        return enumSingleton;
    }
}

class EnumSingleton{
}
