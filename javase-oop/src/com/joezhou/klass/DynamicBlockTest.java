package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DynamicBlockTest {
    @Test
    public void dynamicBlock() {
        new DynamicBlockDemo();
        new DynamicBlockDemo();
        new DynamicBlockDemo();
    }
}

class DynamicBlockDemo {
    public DynamicBlockDemo() {
        System.out.println("DynamicBlockDemo的构造...");
    }

    {
        System.out.println("DynamicBlockDemo的动态块01...");
    }

    {
        System.out.println("DynamicBlockDemo的动态块02...");
    }
}