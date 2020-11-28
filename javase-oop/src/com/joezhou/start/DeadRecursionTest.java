package com.joezhou.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DeadRecursionTest {
    private void methodA() {
        System.out.println("methodA...");
        methodA();
    }
    @Test
    public void deadRecursion() {
        methodA();
    }
}
