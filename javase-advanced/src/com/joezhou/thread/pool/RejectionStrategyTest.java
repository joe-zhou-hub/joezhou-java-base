package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class RejectionStrategyTest {

    private static class MyTask implements Runnable {
        private int i;

        private MyTask(int i) {
            this.i = i;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + ": " + i);
        }

        @Override
        public String toString() {
            return "MyTask{" + "i=" + i + "}";
        }
    }

    private void policy(RejectedExecutionHandler policy) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                policy);

        for (int i = 0, j = 8; i < j; i++) {
            threadPool.execute(new MyTask(i));
        }

        System.out.println("queue:" + threadPool.getQueue());
        threadPool.execute(new MyTask(100));
        System.out.println("queue:" + threadPool.getQueue());
        threadPool.shutdown();
    }

    @Test
    public void abortPolicy() {
        policy(new ThreadPoolExecutor.AbortPolicy());
    }

    @Test
    public void discardPolicy() {
        policy(new ThreadPoolExecutor.DiscardPolicy());
    }

    @Test
    public void discardOldestPolicy() {
        policy(new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    @Test
    public void callerRunsPolicy() {
        policy(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @SneakyThrows
    @After
    public void after(){
        System.out.println(System.in.read());
    }

}
