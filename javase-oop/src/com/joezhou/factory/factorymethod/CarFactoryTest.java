package com.joezhou.factory.factorymethod;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CarFactoryTest {
    @Test
    public void factoryMethod() {
        new BenzFactory().build().drive();
    }
}

interface Car {
    /**
     * 驾驶方法
     */
    void drive();
}

class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("奔驰在跑...");
    }
}

interface CarFactory {
    /**
     * 构建一辆车的实例
     *
     * @return 车的接口实例
     */
    Car build();
}

class BenzFactory implements CarFactory {
    @Override
    public Car build() {
        return new Benz();
    }
}
