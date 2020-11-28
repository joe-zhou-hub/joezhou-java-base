package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author JoeZhou
 */
public class LinkedListTest {

    private LinkedList<String> linkedList;

    @Before
    public void before() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void create() {
        linkedList.add("Korea");
        linkedList.add("Japan");
        linkedList.addFirst("China");
        linkedList.addLast("Thailand");
        linkedList.offer("UK");
        linkedList.offerLast("US");
        linkedList.offerFirst("France");
        linkedList.push("Congo");

        System.out.println("add over: " + linkedList);
    }

    @Test
    public void retrieve() {
        this.create();
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.element());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
    }

    @Test
    public void update() {
        this.create();
        linkedList.set(1, "UK");
        System.out.println(linkedList);
    }

    @Test
    public void remove() {
        this.create();
        System.out.println(linkedList.poll());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollLast());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.remove());
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.remove("UK"));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeFirstOccurrence("Japan"));
        System.out.println(linkedList.removeLastOccurrence("US"));
    }

    @Test
    public void iteratorByFor() {
        this.create();
        for (int i = 0, j = linkedList.size(); i < j; i++) {
            System.out.print(linkedList.get(i) + "\0");
        }
    }

    @Test
    public void iteratorByForEach() {
        this.create();
        for (String str : linkedList) {
            System.out.print(str + "\0");
        }
    }
}
