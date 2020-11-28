package com.joezhou.jvm;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MethodAreaTest {
    @Test
    public void codeReuse() {
        Integer a = 100;
        Integer b = 100;
        Integer c = new Integer(100);
        System.out.println(a == b);
        System.out.println(b == c);
    }
}
