package com.joezhou.thread.communication;

import lombok.Data;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class WaitNotifyTest {

    @Data
    private static class Food {
        private String name;
        private String type;
        private boolean exist;
    }

    private static class AsyncProducer implements Runnable {

        private final Food food;
        private boolean isEnglish;

        AsyncProducer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                if (isEnglish) {
                    food.setName("cake");
                    food.setType("mickey");
                } else {
                    food.setName("dan-gao");
                    food.setType("mi-qi");
                }
                isEnglish = !isEnglish;
            }
        }
    }

    private static class AsyncConsumer implements Runnable {

        private final Food food;

        AsyncConsumer(Food food) {
            this.food = food;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(food.getName() + ": " + food.getType());
            }
        }
    }

    private static class SyncProducer implements Runnable {

        private final Food food;
        private boolean isEnglish;

        SyncProducer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                // Don't use "synchronized (this)"
                synchronized (food) {
                    if (isEnglish) {
                        food.setName("cake");
                        food.setType("mickey");
                    } else {
                        food.setName("dan-gao");
                        food.setType("mi-qi");
                    }
                    isEnglish = !isEnglish;
                }
            }
        }
    }

    private static class SyncConsumer implements Runnable {

        private final Food food;

        SyncConsumer(Food food) {
            this.food = food;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    TimeUnit.MILLISECONDS.sleep(300L);
                    System.out.println(food.getName() + ": " + food.getType());
                }
            }
        }
    }

    private static class OneByOneProducer implements Runnable {

        private final Food food;
        private boolean isEnglish;

        OneByOneProducer(Food food) {
            this.food = food;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    if (food.isExist()) {
                        food.wait();
                    } else {
                        if (isEnglish) {
                            food.setName("cake");
                            food.setType("mickey");
                        } else {
                            food.setName("dan-gao");
                            food.setType("mi-qi");
                        }
                        isEnglish = !isEnglish;
                        food.setExist(true);
                        food.notify();
                    }
                }
            }
        }
    }

    private static class OneByOneConsumer implements Runnable {

        private final Food food;

        OneByOneConsumer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    try {
                        if (food.isExist()) {
                            TimeUnit.SECONDS.sleep(1L);
                            System.out.print(food.getName() + ": " + food.getType() + "\n");
                            food.setExist(false);
                            food.notify();
                        } else {
                            food.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    private Food food = new Food();

    @Test
    public void asynchronousVersion() {
        new Thread(new AsyncProducer(food)).start();
        new Thread(new AsyncConsumer(food)).start();
    }

    @Test
    public void synchronizedVersion() {
        new Thread(new SyncProducer(food)).start();
        new Thread(new SyncConsumer(food)).start();
    }

    @Test
    public void oneByOneVersion() {
        new Thread(new OneByOneProducer(food)).start();
        new Thread(new OneByOneConsumer(food)).start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}


