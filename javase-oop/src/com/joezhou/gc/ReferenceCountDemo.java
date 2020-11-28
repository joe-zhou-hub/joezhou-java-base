package com.joezhou.gc;

/**
 * 建立循环引用，测试当前JDK版本是否使用了引用计数回收策略。
 *
 * 使用 `-verbose:gc -XX:+PrintGCDetails` 运行参数可以看到详细的GC情况，
 * 可以发现PSYoungGen空间变小，说明程序依然执行了GC，也说明jdk1.8使用的不是引用计数回收策略。
 *
 * @author JoeZhou
 */
public class ReferenceCountDemo {
    private ReferenceCountDemo field;

    public static void main(String[] args) {
        ReferenceCountDemo instanceA = new ReferenceCountDemo();
        ReferenceCountDemo instanceB = new ReferenceCountDemo();
        // 让两个实例循环引用，此时两个实例的引用计数均为1
        instanceA.field = instanceB;
        instanceB.field = instanceA;
        // 断开两个实例的堆栈联系，此时堆中的两个对象应为垃圾，但因为互相引用，永远无法被GC回收
        instanceA = null;
        instanceB = null;
        // 事实上内存在GC之后变小了，说明jdk8使用的不是引用计数的回收方式
        System.gc();
    }
}