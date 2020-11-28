package com.joezhou.factory.abstractfactory;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CarFactoryTest {
    @Test
    public void abstractFactory() {
        // by good
        CarFactory goodFactory = new GoodCarFactory();
        goodFactory.getEngine().info();
        goodFactory.getTires().info();

        // by bad
        CarFactory badFactory = new BadCarFactory();
        badFactory.getEngine().info();
        badFactory.getTires().info();
    }
}

interface Tires {
    void info();
}

class GoodTires implements Tires {
    @Override
    public void info() {
        System.out.println("好轮胎...");
    }
}

class BadTires implements Tires {
    @Override
    public void info() {
        System.out.println("坏轮胎...");
    }
}

interface Engine {
    void info();
}

class GoodEngine implements Engine {
    @Override
    public void info() {
        System.out.println("好发动机...");
    }
}

class BadEngine implements Engine {
    @Override
    public void info() {
        System.out.println("坏发动机...");
    }
}

interface CarFactory {
    /**
     * 获取发动机
     *
     * @return 发动机实例
     */
    Engine getEngine();

    /**
     * 获取轮胎
     *
     * @return 轮胎实例
     */
    Tires getTires();
}

class GoodCarFactory implements CarFactory {

    @Override
    public Engine getEngine() {
        return new GoodEngine();
    }

    @Override
    public Tires getTires() {
        return new GoodTires();
    }
}

class BadCarFactory implements CarFactory {

    @Override
    public Engine getEngine() {
        return new BadEngine();
    }

    @Override
    public Tires getTires() {
        return new BadTires();
    }
}
