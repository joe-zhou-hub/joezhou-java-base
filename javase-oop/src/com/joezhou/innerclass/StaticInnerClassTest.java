package com.joezhou.innerclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class StaticInnerClassTest {
    @Test
    public void staticInnerClass() {
        StaticOuter.StaticInner staticInner = new StaticOuter.StaticInner();
        staticInner.method();
        StaticOuter.StaticInner.staticMethod();
    }
}

class StaticOuter {
    private int field = 1;
    private static int staticField = 2;

    static class StaticInner {
        private int field = 3;
        private static int staticField = 4;

        public void method() {
            System.out.println(field);
            System.out.println(staticField);
            System.out.println(new StaticOuter().field);
            System.out.println(StaticOuter.staticField);
            // System.out.println(Outer.this.field);
        }

        public static void staticMethod() {
            System.out.println(staticField);
            System.out.println(new StaticOuter().field);
            System.out.println(StaticOuter.staticField);
            // System.out.println(field);
            // System.out.println(Outer.this.field);
        }
    }
}
