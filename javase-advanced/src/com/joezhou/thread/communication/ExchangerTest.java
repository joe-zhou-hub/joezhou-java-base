package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ExchangerTest {

    @Test
    public void exchange() {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
                System.out.println("Buyer ready...");
                String exchangedValue = exchanger.exchange("10 yuan");
                System.out.println("Buyer got " + exchangedValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Seller ready...");
                String exchangedValue = exchanger.exchange("bread");
                System.out.println("Seller got " + exchangedValue);
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