package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class CompletableFutureTest {

    @SneakyThrows
    private String taskA() {
        TimeUnit.SECONDS.sleep(1L);
        System.out.println("taskA over...");
        return "taskA-over";
    }

    @SneakyThrows
    private String taskB() {
        TimeUnit.SECONDS.sleep(2L);
        System.out.println("taskB over...");
        return "taskB-over";

    }

    @SneakyThrows
    private String taskC() {
        TimeUnit.SECONDS.sleep(3L);
        System.out.println("taskC over...");
        return "taskC-over";
    }


    @SneakyThrows
    private void taskD() {
        TimeUnit.SECONDS.sleep(1L);
        System.out.println("taskD over...");
    }

    @SneakyThrows
    private void taskE() {
        TimeUnit.SECONDS.sleep(2L);
        System.out.println("taskE over...");

    }

    @SneakyThrows
    private void taskF() {
        TimeUnit.SECONDS.sleep(3L);
        System.out.println("taskF over...");
    }

    @SneakyThrows
    @Test
    public void performTask() {
        long start = System.currentTimeMillis();
        taskA();
        taskB();
        taskC();
        taskD();
        taskE();
        taskF();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @SneakyThrows
    @Test
    public void performTaskByCompletableFuture() {
        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(this::taskA);
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(this::taskB);
        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(this::taskC);
        CompletableFuture<Void> futureD = CompletableFuture.runAsync(this::taskD);
        CompletableFuture<Void> futureE = CompletableFuture.runAsync(this::taskE);
        CompletableFuture<Void> futureF = CompletableFuture.runAsync(this::taskF);
        CompletableFuture<Void> future = CompletableFuture.allOf(futureA, futureB, futureC, futureD, futureE, futureF);
        future.join();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
