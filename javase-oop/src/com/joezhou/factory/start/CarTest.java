package com.joezhou.factory.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CarTest {
    @Test
    public void factory() {
        new Benz().drive();
    }
}

interface Car {
    /**驾驶方法*/
    void drive();
}

class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("奔驰在跑...");
    }
}
