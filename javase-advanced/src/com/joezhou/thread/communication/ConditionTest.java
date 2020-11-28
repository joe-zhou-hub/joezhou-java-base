package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JoeZhou
 */
public class ConditionTest {

    private static class ConditionDemo {
        private List<String> list = new ArrayList<>();
        private Lock lock = new ReentrantLock();
        private Condition producer = lock.newCondition();
        private Condition consumer = lock.newCondition();

        public void put(String data) {
            int max = 10;
            lock.lock();
            try {
                while (list.size() == max) {
                    producer.await();
                }
                list.add(data);
                consumer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public String get() {
            String result = null;
            lock.lock();
            try {
                while (list.size() == 0) {
                    consumer.await();
                }
                result = list.remove(0);
                producer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return result;
        }
    }

    @SneakyThrows
    @Test
    public void condition() {
        ConditionDemo conditionDemo = new ConditionDemo();

        for (int i = 0, j = 10; i < j; i++) {
            new Thread(() -> {
                for (int m = 0, n = 5; m < n; m++) {
                    System.out.println(Thread.currentThread().getName() + " got: " + conditionDemo.get());
                }
            }, "consumer-" + i).start();
        }

        TimeUnit.SECONDS.sleep(2L);

        for (int i = 0, j = 2; i < j; i++) {
            new Thread(() -> {
                for (int m = 0, n = 25; m < n; m++) {
                    conditionDemo.put(Thread.currentThread().getName() + ": " + m);
                }
            }, "producer-" + i).start();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }

}
