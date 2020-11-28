package com.joezhou.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class JunitTest {

    @Before
    public void before() {
        System.out.println("junit-before");
    }

    @Test
    public void methodA() {
        System.out.println("methodA!");
    }

    @Test
    public void methodB() {
        System.out.println("methodB!");
    }

    @After
    public void after() {
        System.out.println("junit-after");
    }
}