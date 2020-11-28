package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class PolymorphismTest {
    @Test
    public void override() {
        new Parent().method();
        new Son().method();
    }

    @Test
    public void overload() {
        new Son().method();
        new Son().method(100);
    }
}

class Parent {
    public void method() {
        System.out.println("method in Parent...");
    }
}

class Son extends Parent {
    @Override
    public void method() {
        System.out.println("method in Son...");
    }

    public void method(int num) {
        System.out.println("method in Son..." + num);
    }
}
