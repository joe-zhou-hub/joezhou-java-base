package com.joezhou.annotation;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DeprecatedTest {

    private static class DeprecatedDemo {
        @Deprecated
        public void method() {
            System.out.println("deprecated method...");
        }
    }

    @Test
    public void studentDeprecated() {
        new DeprecatedDemo().method();
    }
}


