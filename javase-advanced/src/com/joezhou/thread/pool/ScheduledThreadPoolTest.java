package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ScheduledThreadPoolTest {

    @Test
    public void schedule() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.schedule(() -> {
            System.out.println("delay 2s and print");
        }, 2, TimeUnit.SECONDS);
    }

    @Test
    public void scheduleAtFixedRate() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("delay 2s and every 1s");
        }, 2,1, TimeUnit.SECONDS);
    }

    @Test
    public void scheduleWithFixedDelay() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("delay 2s and every 1s");
        }, 2,1, TimeUnit.SECONDS);
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
