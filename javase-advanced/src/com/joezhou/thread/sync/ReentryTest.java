package com.joezhou.thread.sync;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ReentryTest {

    private synchronized void methodA() {
        System.out.println("methodA...");
        // Found to be the same thread, allowing reentry
        methodB();
    }

    private synchronized void methodB() {
        System.out.println("methodB...");
    }

    @Test
    public void reentry() {
        new ReentryTest().methodA();
    }
}
