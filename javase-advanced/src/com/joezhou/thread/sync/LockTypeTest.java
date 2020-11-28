package com.joezhou.thread.sync;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class LockTypeTest {

    private static class LockTypeDemoA implements Runnable {

        private int ticketNo;

        @SneakyThrows
        @Override
        public void run() {
            String threadA = "threadA";
            while (true) {
                if (Thread.currentThread().getName().equals(threadA)) {
                    sellTicket();
                } else {
                    synchronized (this) {
                        int maxNo = 100;
                        if (ticketNo < maxNo) {
                            ticketNo++;
                            TimeUnit.SECONDS.sleep(1L);
                            String threadName = Thread.currentThread().getName();
                            System.out.println(threadName + "卖票: " + ticketNo);
                        }
                    }
                }
            }
        }

        @SneakyThrows
        private synchronized void sellTicket() {
            int maxNo = 100;
            if (ticketNo < maxNo) {
                ticketNo++;
                TimeUnit.SECONDS.sleep(1L);
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + "卖票: " + ticketNo);
            }
        }
    }

    private static class LockTypeDemoB implements Runnable {

        private static int ticketNo;

        @SneakyThrows
        @Override
        public void run() {
            String threadA = "threadA";
            while (true) {
                if (Thread.currentThread().getName().equals(threadA)) {
                    sellTicket();
                } else {
                    synchronized (LockTypeDemoB.class) {
                        int maxNo = 100;
                        if (ticketNo < maxNo) {
                            ticketNo++;
                            TimeUnit.SECONDS.sleep(1L);
                            String threadName = Thread.currentThread().getName();
                            System.out.println(threadName + "卖票: " + ticketNo);
                        }
                    }
                }
            }
        }

        @SneakyThrows
        private static synchronized void sellTicket() {
            int maxNo = 100;
            if (ticketNo < maxNo) {
                ticketNo++;
                TimeUnit.SECONDS.sleep(1L);
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + "卖票: " + ticketNo);
            }
        }
    }

    @Test
    public void memberMethodLockType() {
        Runnable runnable = new LockTypeDemoA();
        new Thread(runnable, "threadA").start();
        new Thread(runnable, "threadB").start();
    }

    @Test
    public void staticMethodLockType() {
        Runnable runnable = new LockTypeDemoB();
        new Thread(runnable, "threadA").start();
        new Thread(runnable, "threadB").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}




