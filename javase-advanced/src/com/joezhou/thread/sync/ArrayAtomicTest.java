package com.joezhou.thread.sync;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author JoeZhou
 */
public class ArrayAtomicTest {

    @Test
    public void atomicIntegerArray() {
        AtomicIntegerArray arr = new AtomicIntegerArray(new int[]{3, 2});
        System.out.println("arr[0]：" + arr.get(0));
        System.out.println("++(arr[0])：" + arr.incrementAndGet(0));
        System.out.println("--(arr[0])：" + arr.decrementAndGet(0));
        System.out.println("(arr[0])+=6 then return：" + arr.addAndGet(0, 6));
        System.out.println("accumulate then return：" + arr.accumulateAndGet(0, 5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right + 9) / 3;
                }
        ));
        System.out.println("arr[0]：" + arr.get(0));
    }

    @Test
    public void atomicLongArray() {
        AtomicLongArray arr = new AtomicLongArray(new long[]{3, 2});
        System.out.println("arr[0]：" + arr.get(0));
        System.out.println("(arr[0])++：" + arr.getAndIncrement(0));
        System.out.println("(arr[0])--：" + arr.getAndDecrement(0));
        System.out.println("return then (arr[0])-=6：" + arr.getAndAdd(0, -6));
        System.out.println("return then accumulate：" + arr.getAndAccumulate(0, 5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right + 9) / 3;
                }
        ));
        System.out.println("arr[0]：" + arr.get(0));
    }

    @Test
    public void atomicReferenceArray() {
        AtomicReferenceArray<String> arr = new AtomicReferenceArray<>(new String[]{"3", "2"});
        System.out.println("arr[0]：" + arr.get(0));
        System.out.println("update then return" + arr.updateAndGet(0, v -> v + "-"));
        System.out.println("arr[0]：" + arr.get(0));
    }

}