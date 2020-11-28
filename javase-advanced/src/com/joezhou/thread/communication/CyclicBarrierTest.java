package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class CyclicBarrierTest {

    @Test
    public void cyclicBarrier() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("Enough for 3 people，start playing cards...");
        });

        for (int i = 0, j = 8; i < j; i++) {
            long sleepTime = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(sleepTime);
                    System.out.println(Thread.currentThread().getName()
                            + ": ready..."
                            + cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": playing...");
            }).start();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}