package com.joezhou.thread.communication;

import lombok.Data;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class StopThreadTest {

    @Data
    private static class NormalThreadDemo implements Runnable {

        private boolean isStop;

        @SneakyThrows
        @Override
        public synchronized void run() {
            while (!isStop) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("thread run...");
            }
            System.out.println("thread over...");
        }
    }

    @Data
    private static class SuspendedThreadDemo implements Runnable {

        private boolean isStop;

        @SneakyThrows
        @Override
        public synchronized void run() {
            while (!isStop) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    isStop = true;
                    e.printStackTrace();
                    System.out.println("thread over...");
                }
            }
        }
    }

    @SneakyThrows
    @Test
    public void stopNormalThread() {
        NormalThreadDemo normalThreadDemo = new NormalThreadDemo();
        new Thread(normalThreadDemo).start();
        TimeUnit.SECONDS.sleep(5L);
        normalThreadDemo.setStop(true);
    }

    @SneakyThrows
    @Test
    public void stopSuspendedThread() {
        SuspendedThreadDemo suspendedThreadDemo = new SuspendedThreadDemo();
        Thread thread = new Thread(suspendedThreadDemo);
        thread.start();
        TimeUnit.SECONDS.sleep(5L);
        thread.interrupt();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}