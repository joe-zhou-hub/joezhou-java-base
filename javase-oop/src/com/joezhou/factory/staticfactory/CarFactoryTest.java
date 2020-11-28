package com.joezhou.factory.staticfactory;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CarFactoryTest {
    @Test
    public void staticFactory() {
        CarFactory.getBenz().drive();
    }
}

interface Car {
    void drive();
}

class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("奔驰在跑...");
    }
}

class CarFactory {
    public static Car getBenz() {
        return new Benz();
    }
}
