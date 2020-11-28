package com.joezhou.innerclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MemberInnerClassTest {
    @Test
    public void innerClass() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.innerMethod();
    }
}

class Outer {
    private String field = "field-outer";
    class Inner {
        private String field = "field-inner";
        public void innerMethod() {
            System.out.println(field);
            System.out.println(new Outer().field);
            System.out.println(Outer.this.field);
        }
    }
}
