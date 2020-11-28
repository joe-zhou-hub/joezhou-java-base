package com.joezhou.gc;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * -Xms20M -Xmx20M
 *
 * @author JoeZhou
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        System.gc();
        TimeUnit.SECONDS.sleep(1L);
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get() == null ? "be recycled" : "not recycled");
        System.gc();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(softReference.get() == null ? "be recycled" : "not recycled");
        byte[] bsB = new byte[1024 * 1024 * 11];
        System.out.println(softReference.get() == null ? "be recycled" : "not recycled");
    }
}