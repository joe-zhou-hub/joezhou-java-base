package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class PhaserTest {

    private static Phaser phaser;

    @Before
    public void before() {
        phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                final int levelOne = 1;
                final int levelTwo = 2;
                if (phase == 0) {
                    System.out.println(registeredParties + " hero ready...\n");
                    return false;
                }
                if (phase == levelOne) {
                    System.out.println(registeredParties + " hero passed level one...\n");
                    return false;
                }
                if (phase == levelTwo) {
                    System.out.println(registeredParties + " hero passed level two...\n");
                    return false;
                }
                System.out.println("over...");
                return true;
            }
        };
    }

    private static class Hero implements Runnable {

        private int heroLevel;

        private Hero(int heroLevel) {
            this.heroLevel = heroLevel;
        }

        @SneakyThrows
        private void ready() {
            TimeUnit.SECONDS.sleep(1L);
            System.out.println(Thread.currentThread().getName() + " ready...");
            phaser.arriveAndAwaitAdvance();
        }

        @SneakyThrows
        private void levelOne() {
            final int levelLimit = 2;
            if (heroLevel > levelLimit) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(Thread.currentThread().getName() + " passed level one...");
                phaser.arriveAndAwaitAdvance();
            }
        }

        @SneakyThrows
        private void levelTwo() {
            final int levelLimit = 4;
            if (heroLevel > levelLimit) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(Thread.currentThread().getName() + " passed level two...");
                phaser.arriveAndAwaitAdvance();
            }
            // Can only be written in the last level
            System.out.println(Thread.currentThread().getName() + " deregister...");
            phaser.arriveAndDeregister();
        }

        @Override
        public void run() {
            ready();
            levelOne();
            levelTwo();
        }
    }

    @Test
    public void phaser() {
        final int parties = 6;
        phaser.bulkRegister(parties);
        for (int i = 0; i < parties; i++) {
            new Thread(new Hero(i + 1), "hero-" + i).start();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
