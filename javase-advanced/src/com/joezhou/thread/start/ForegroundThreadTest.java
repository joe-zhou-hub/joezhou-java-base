package com.joezhou.thread.start;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ForegroundThreadTest {

    private static class SubThread extends Thread {
        @Override
        public void run() {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }
    }

    private static class SubRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void buildByThread() {
        SubThread thread = new SubThread();
        thread.start();
    }

    @Test
    public void buildByInnerThread() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0, j = 10; i < j; i++) {
                    System.out.println(i);
                }
            }
        }.start();
    }

    @Test
    public void buildByRunnable() {
        SubRunnable subRunnable = new SubRunnable();
        Thread thread = new Thread(subRunnable);
        thread.start();
    }

    @Test
    public void buildByInnerRunnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j = 10; i < j; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();
    }

    @Test
    public void buildByLambda() {
        new Thread(() -> {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }).start();

    }

    @After
    public void after() throws IOException {
        System.out.println(System.in.read());
    }
}
