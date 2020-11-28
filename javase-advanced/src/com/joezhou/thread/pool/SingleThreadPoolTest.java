package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class SingleThreadPoolTest {

    @Test
    public void cachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0, j = 10; i < j; i++) {
            TimeUnit.SECONDS.sleep(1);
            executorService.execute(() -> {
                System.out.println("hello!");
            });
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
