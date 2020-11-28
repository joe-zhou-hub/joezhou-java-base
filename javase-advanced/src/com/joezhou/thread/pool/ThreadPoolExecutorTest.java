package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class ThreadPoolExecutorTest {

    @SneakyThrows
    @Test
    public void threadPoolExecutor() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 4, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        threadPool.execute(() -> {
            System.out.println("runnable...");
        });

        TimeUnit.SECONDS.sleep(2L);

        Future<Integer> future = threadPool.submit(() -> {
            System.out.println("callable...");
            return 100;
        });
        System.out.println(future.get());
    }


    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
