package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * @author JoeZhou
 */
public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void before() {
        stack = new Stack<>();
    }

    @Test
    public void create() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("create over: " + stack);
    }

    @Test
    public void retrieve() {
        this.create();
        System.out.println(stack.peek());
        System.out.println(stack.search(3));
    }

    @Test
    public void delete() {
        this.create();
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    @Test
    public void iteratorByForEach() {
        for (int e : stack) {
            System.out.println(e);
        }
    }

    @Test
    public void iteratorByPop() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\0");
        }
    }
}
