package com.joezhou.thread.sync;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author JoeZhou
 */
public class BaseAtomicTest {

    @Test
    public void atomicInteger() {
        AtomicInteger num = new AtomicInteger(0);
        System.out.println("num：" + num.get());
        System.out.println("++num：" + num.incrementAndGet());
        System.out.println("--num：" + num.decrementAndGet());
        System.out.println("num+=6 then return：" + num.addAndGet(6));
        System.out.println("accumulate then return：" + num.accumulateAndGet(5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right - 9) / 3;
                }
        ));
        System.out.println("num：" + num.get());
    }

    @Test
    public void atomicLong() {
        AtomicLong num = new AtomicLong(0L);
        System.out.println("num：" + num.get());
        System.out.println("num++：" + num.getAndIncrement());
        System.out.println("num--：" + num.getAndDecrement());
        System.out.println("return then num-=6：" + num.getAndAdd(-6));
        System.out.println("return then accumulate：" + num.getAndAccumulate(5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right - 9) / 3;
                }
        ));
        System.out.println("num：" + num.get());
    }

    @Test
    public void atomicBoolean() {
        AtomicBoolean flag = new AtomicBoolean(false);
        System.out.println("flag：" + flag.get());
        System.out.println("change to true：" + flag.getAndSet(true));
        System.out.println("flag：" + flag.get());
    }
}