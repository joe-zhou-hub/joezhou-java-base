package com.joezhou.thread.lock;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JoeZhou
 */
public class ReentrantLockTest {

    private static class LockDemo implements Runnable {
        private Lock lock = new ReentrantLock();

        private void method() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread() + ": over");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0, j = 5; i < j; i++) {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println(Thread.currentThread() + ": " + i);
                }
                method();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class TryLockDemo {
        private Lock lock = new ReentrantLock();

        private void methodA() {
            try {
                lock.lock();
                for (int i = 0, j = 5; i < j; i++) {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println(Thread.currentThread() + ": " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void methodB() {
            boolean locked = false;
            try {
                // Try to acquire the lock within 3 seconds
                locked = lock.tryLock(3, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + ": " + locked);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (locked) {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void lock() {
        LockDemo lockDemo = new LockDemo();
        new Thread(lockDemo).start();
        new Thread(lockDemo).start();
    }

    @Test
    public void tryLock() throws Exception {
        TryLockDemo trylockDemo = new TryLockDemo();
        new Thread(trylockDemo::methodA, "threadA").start();
        TimeUnit.SECONDS.sleep(1L);
        new Thread(trylockDemo::methodB, "threadB").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
