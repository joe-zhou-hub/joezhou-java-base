package com.joezhou.thread.sync;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Joe
 */
public class DeadLockTest {

    private static class DeadLockRunnable implements Runnable {

        private final Object objA = new Object();
        private final Object objB = new Object();

        @SneakyThrows
        @Override
        public void run() {
            String threadA = "threadA";
            if (Thread.currentThread().getName().equals(threadA)) {
                synchronized (objA) {
                    System.out.println("if: objA");
                    TimeUnit.SECONDS.sleep(1L);
                    synchronized (objB) {
                        System.out.println("if: objB");
                    }
                }
            } else {
                synchronized (objB) {
                    System.out.println("else: objB");
                    TimeUnit.SECONDS.sleep(1L);
                    synchronized (objA) {
                        System.out.println("else: objA");
                    }
                }
            }
        }
    }

    @Test
    public void staticMethodLockType() {
        Runnable runnable = new DeadLockRunnable();
        new Thread(runnable, "threadA").start();
        new Thread(runnable, "threadB").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }

}

