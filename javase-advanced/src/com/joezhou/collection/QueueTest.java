package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JoeZhou
 */
public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void before() {
        queue = new LinkedList<>();
    }

    @Test
    public void create() {
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("create over: " + queue);
    }

    @Test
    public void retrieve() {
        this.create();
        System.out.println("element: " + queue.element());
        System.out.println("peek: " + queue.peek());
    }

    @Test
    public void delete() {
        this.create();
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    @Test
    public void iteratorByForEach() {
        this.create();
        for (int e : queue) {
            System.out.print(e + "\0");
        }
    }

    @Test
    public void iteratorByPoll() {
        this.create();
        while (!queue.isEmpty()) {
            System.out.println("poll: " + queue.poll());
        }
    }
}
