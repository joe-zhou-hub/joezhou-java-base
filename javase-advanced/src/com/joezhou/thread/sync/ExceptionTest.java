package com.joezhou.thread.sync;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ExceptionTest {

    private static class ExceptionDemo implements Runnable {

        private int count;

        @Override
        public synchronized void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + count);
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    if (count++ == 3) {
                        throw new ArithmeticException();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void exception() {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        new Thread(exceptionDemo, "threadA").start();
        new Thread(exceptionDemo, "threadB").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
