package com.joezhou.reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class ReflectMethodTest {
    private Class<?> klass = Demo.class;

    static class Demo {
        public static void methodA(String str, int num) {
            System.out.println("I am methodA..." + str + num);
        }

        private static void methodB() {
            System.out.println("I am methodB...");
        }
    }

    @Test
    public void reflectMethods() throws NoSuchMethodException {
        System.out.println(Arrays.toString(klass.getMethods()));
        System.out.println(Arrays.toString(klass.getDeclaredMethods()));
        System.out.println(klass.getMethod("methodA", String.class, int.class));
        System.out.println(klass.getDeclaredMethod("methodB"));
    }

    @Test
    public void usePublicMethod() throws Exception {
        Method methodA = klass.getMethod("methodA", String.class, int.class);
        methodA.invoke(klass.getDeclaredConstructor().newInstance(), "赵四", 58);
    }

    @Test
    public void usePrivateMethod() throws Exception {
        Method methodB = klass.getDeclaredMethod("methodB");
        methodB.setAccessible(true);
        methodB.invoke(klass.getDeclaredConstructor().newInstance());
    }
}