package com.joezhou.thread.sync;

import org.junit.Test;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author JoeZhou
 */
public class AdderTest {

    @Test
    public void longAdder() {
        LongAdder num = new LongAdder();
        System.out.println("current value: " + num);
        num.add(5);
        System.out.println("after +5：" + num);
        num.increment();
        System.out.println("after +1：" + num);
        num.decrement();
        System.out.println("after -1：" + num);
    }

    @Test
    public void doubleAdder() {
        DoubleAdder num = new DoubleAdder();
        System.out.println("current value: " + num);
        num.add(5);
        System.out.println("after +5：" + num);
    }
}