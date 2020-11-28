package com.joezhou.thread.collection;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class SynchronizedQueueTest {

    private static class MyTask implements Delayed {

        private String taskName;
        private Long timestamp;

        MyTask(String taskName, Long timestamp) {
            this.taskName = taskName;
            this.timestamp = timestamp;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(timestamp - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return taskName + ": " + timestamp;
        }
    }

    @Test
    public void concurrentLinkedQueue() {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("zhao-si");
        System.out.println(queue.poll());
    }

    @Test
    public void linkedBlockingQueue() {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        System.out.println(queue.isEmpty());
        new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(2L);
                    int data = new Random().nextInt(100);
                    queue.put(data);
                    System.out.println("produce: " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer").start();

        for (int i = 0, j = 5; i < j; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer-" + i).start();
        }
    }

    @Test
    public void linkedBlockingDeque() {
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.addFirst("zhao-si");
        queue.addLast("liu-neng");
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        System.out.println(queue);
    }

    @SneakyThrows
    @Test
    public void arrayBlockingQueue() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0, j = 10; i < j; i++) {
            queue.put(i);
        }
        System.out.println(queue.size());

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // blocking and wait for consumer
        queue.put(250);
        System.out.println("over...");
    }

    @SneakyThrows
    @Test
    public void delayQueue() {
        BlockingQueue<MyTask> queue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        queue.put(new MyTask("task1", now + 3));
        queue.put(new MyTask("task4", now + 1));
        queue.put(new MyTask("task5", now + 2));
        for (int i = 0, j = queue.size(); i < j; i++) {
            System.out.println(queue.take());
        }
    }

    @SneakyThrows
    @Test
    public void synchronousQueue() {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2L);
        queue.put("zhao-si");
        System.out.println("size: " + queue.size());
    }

    @Test
    public void linkedTransferQueue() {
        TransferQueue<String> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                System.out.println("consumer start...");
                TimeUnit.SECONDS.sleep(2L);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        new Thread(() -> {
            try {
                System.out.println("producer start...");
                queue.transfer("zhao-si");
                // queue.put("zhao-si");
                System.out.println("producer继续运行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }

}
