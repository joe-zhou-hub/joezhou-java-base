package com.joezhou.annotation;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class OverrideTest {
    private static class OverrideDemo {
        @Override
        public String toString() {
            return "重写了toString()";
        }
    }

    @Test
    public void studentToString() {
        System.out.println(new OverrideDemo().toString());
    }
}


