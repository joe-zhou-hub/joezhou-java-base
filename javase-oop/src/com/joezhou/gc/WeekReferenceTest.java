package com.joezhou.gc;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class WeekReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        System.out.println(weakReference.get() == null ? "be recycled" : "not recycled");
        System.gc();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(weakReference.get() == null ? "be recycled" : "not recycled");
    }
}