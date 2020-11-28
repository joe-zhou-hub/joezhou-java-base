package com.joezhou.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 -Xms20M -Xmx20M 限制堆内存大小为20M。
 *
 * @author JoeZhou
 */
public class HeapOutOfMemoryDemo {
    /**
     * 声明类内部静态类（非private），生命周期和外部类HeapOutOfMemory一样长，
     * 使垃圾收集器无法回收这些对象占用的内存空间
     */
    static class HeapOutOfMemoryInner {
    }

    public static void main(String[] args) {
        List<HeapOutOfMemoryInner> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOutOfMemoryInner());
            System.out.println(list.size());
        }
    }
}