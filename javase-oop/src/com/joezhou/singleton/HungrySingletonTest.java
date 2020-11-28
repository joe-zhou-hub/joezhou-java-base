package com.joezhou.singleton;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class HungrySingletonTest {
    @Test
    public void hungrySingleton() {
        HungrySingleton instanceA = HungrySingleton.getInstance();
        HungrySingleton instanceB = HungrySingleton.getInstance();
        System.out.println(instanceA == instanceB);
    }
}

class HungrySingleton {

    private final static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}