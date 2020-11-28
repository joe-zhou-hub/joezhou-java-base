package com.joezhou.thread.start;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ThreadApiTest {

    @Test
    public void baseApi() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "threadA");
        thread.setName("threadB");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread.getPriority());
        System.out.println(thread.getName());
        System.out.println(thread.isAlive());
        thread.start();
        System.out.println(thread.isAlive());
    }

    @Test
    public void sleep() throws InterruptedException {
        System.out.println("thread-main: start...");
        Thread.sleep(2000L);
        System.out.println("thread-main: over...");

        System.out.println("thread-main: start...");
        TimeUnit.SECONDS.sleep(2L);
        System.out.println("thread-main: over...");
    }

    @Test
    public void join() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0, j = 5; i < j; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread threadA = new Thread(runnable, "threadA");
        Thread threadB = new Thread(runnable, "threadB");

        threadA.start();
        threadA.join();

        threadB.start();

        for (int i = 0, j = 5; i < j; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    @Test
    public void yeild() {

        new Thread(() -> {
            for (int i = 0, j = 5; i < j; i++) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName());
            }
        }, "thread").start();

        for (int i = 0, j = 5; i < j; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    @After
    public void after() throws IOException {
        System.out.println(System.in.read());
    }
}
