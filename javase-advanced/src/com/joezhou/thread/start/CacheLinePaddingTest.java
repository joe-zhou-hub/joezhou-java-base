package com.joezhou.thread.start;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CacheLinePaddingTest {

    private final static long COUNT = 1_0000_0000L;

    private static class Demo {
        //private long p1, p2, p3, p4, p5, p6, p7;
        private volatile long x = 0L;
        //private long p9, p10, p11, p12, p13, p14, p15;
    }

    private static Demo[] demos = new Demo[2];

    static {
        demos[0] = new Demo();
        demos[1] = new Demo();
    }

    @Test
    public void cacheLinePaddingEfficiency() {
        new Thread(() -> {
            long start = System.currentTimeMillis();
            for (long i = 0; i < COUNT; i++) {
                demos[0].x = i;
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            for (long i = 0; i < COUNT; i++) {
                demos[1].x = i;
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }).start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
