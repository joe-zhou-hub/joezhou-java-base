package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class StaticBlockTest {
    @Test
    public void dynamicBlock() {
        new StaticBlockDemo();
        new StaticBlockDemo();
        new StaticBlockDemo();
    }
}

class StaticBlockDemo {
    public StaticBlockDemo() {
        System.out.println("StaticBlockDemo的构造...");
    }

    {
        System.out.println("StaticBlockDemo的动态块01...");
    }

    {
        System.out.println("StaticBlockDemo的动态块02...");
    }

    static {
        System.out.println("StaticBlockDemo的静态块01...");
    }

    static {
        System.out.println("StaticBlockDemo的静态块02...");
    }
}
