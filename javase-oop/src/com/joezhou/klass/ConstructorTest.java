package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ConstructorTest {
    @Test
    public void constructor() {
        new ConstructorDemo();
        new ConstructorDemo("赵四");
        new ConstructorDemo(15, 16);
    }
}

class ConstructorDemo {
    public ConstructorDemo() {
        System.out.println("ConstructorDemo 的无参构造...");
    }

    public ConstructorDemo(String str) {
        System.out.println("ConstructorDemo 的有参构造..." + str);
    }

    public ConstructorDemo(int numA, int numB) {
        System.out.println("ConstructorDemo 的有参构造..." + (numA + numB));
    }
}
