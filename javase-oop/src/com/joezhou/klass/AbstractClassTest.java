package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class AbstractClassTest {
    @Test
    public void buildBySubClass() {
        BaseStartDemo baseStartDemo = new MyStartDemo();
        baseStartDemo.methodA();
        baseStartDemo.methodB();
        baseStartDemo.methodC();
    }
}

abstract class BaseStartDemo {
    public void methodA() {
        System.out.println("methodA");
    }

    public abstract void methodB();

    public abstract void methodC();
}

class MyStartDemo extends BaseStartDemo {
    @Override
    public void methodB() {
        System.out.println("子类重写了methodB...");
    }

    @Override
    public void methodC() {
        System.out.println("子类重写了methodC...");
    }
}
