package com.joezhou.thread.sync;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ThreadLocalTest {

    private static class Person {
    }

    private ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    @Test
    public void threadLocal() {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1L);
                threadLocal.set(new Person());
                System.out.println("set: over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
                // get null
                System.out.println("get: " + threadLocal.get());
                // prevent memory leaks
                threadLocal.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}