package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class FutureTaskTest {
    @SneakyThrows
    @Test
    public void futureTask() {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(2L);
            return 100;
        });

        new Thread(futureTask).start();
        System.out.println("thread-main...");
        System.out.println("thread-main...");

        // blocking
        System.out.println(futureTask.get());
        System.out.println("thread-main...");
        System.out.println("thread-main...");
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
