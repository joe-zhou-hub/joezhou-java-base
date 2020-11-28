package com.joezhou.thread.pool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JoeZhou
 */
public class CustomThreadPoolTest {

    private static class CustomThreadFactory implements ThreadFactory {

        private final AtomicInteger threadId = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "myThread-" + threadId.getAndIncrement());
        }
    }

    private static class CustomRejectedPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            System.out.println(((CustomTask) r).getTaskName() + " is rejected!");
        }
    }

    @AllArgsConstructor
    @Data
    private static class CustomTask implements Runnable {
        private String taskName;

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": " + taskName + " is running!");
            TimeUnit.SECONDS.sleep(3L);
        }
    }

    @Test
    @SneakyThrows
    public void customThreadPool() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(),
                new CustomRejectedPolicy());

        for (int i = 0, j = 8; i < j; i++) {
            threadPool.execute(new CustomTask("myTask-" + i));
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}

