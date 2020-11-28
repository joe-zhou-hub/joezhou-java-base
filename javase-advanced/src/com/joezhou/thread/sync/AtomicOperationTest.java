package com.joezhou.thread.sync;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JoeZhou
 */
public class AtomicOperationTest {

    private int num;
    private AtomicInteger atomicNum = new AtomicInteger(0);

    @Test
    public /*synchronized*/ void nonAtomicOperation() {
        for (int i = 0, j = 100; i < j; i++) {
            new Thread(() -> {
                for (int m = 0, n = 100; m < n; m++) {
                    num++;
                }
                System.out.println(num);
            }).start();
        }
    }

    @Test
    public void atomicOperation() {
        for (int i = 0, j = 100; i < j; i++) {
            new Thread(() -> {
                for (int m = 0, n = 100; m < n; m++) {
                    atomicNum.incrementAndGet();
                }
                System.out.println(atomicNum);
            }).start();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }

}