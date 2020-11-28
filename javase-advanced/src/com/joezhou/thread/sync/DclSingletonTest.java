package com.joezhou.thread.sync;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DclSingletonTest {
    private static class DclSingleton {
        /**
         * why use volatile?
         */
        private volatile static DclSingleton singleton;

        private DclSingleton() {
        }

        public static DclSingleton getInstance() {
            // for improve efficiency
            if (singleton == null) {
                synchronized (DclSingleton.class) {
                    if (singleton == null) {
                        singleton = new DclSingleton();
                    }
                }
            }
            return singleton;
        }
    }

    @Test
    public void dclSingleton() {
        for (int i = 0, j = 10; i < j; i++) {
            new Thread(() -> {
                System.out.println(DclSingleton.getInstance());
            }).start();
        }
    }
}
