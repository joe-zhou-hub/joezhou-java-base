package com.joezhou.singleton;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class FullSingletonTest {
    @Test
    public void fullSingleton() {
        FullSingleton instanceA = FullSingleton.getInstance();
        FullSingleton instanceB = FullSingleton.getInstance();
        System.out.println(instanceA == instanceB);
    }
}

class FullSingleton {

    private static FullSingleton instance;

    private FullSingleton() {
    }

    public static FullSingleton getInstance() {
        if (instance == null) {
            instance = new FullSingleton();
        }
        return instance;
    }
}
