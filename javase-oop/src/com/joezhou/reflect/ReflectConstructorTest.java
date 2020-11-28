package com.joezhou.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class ReflectConstructorTest {

    static class Demo {

        public Demo(int num, String str) {
            System.out.println("public constructor...");
        }

        private Demo() {
            System.out.println("private constructor...");
        }

        public void sayHello() {
            System.out.println("hello!");
        }
    }

    private Class<?> klass = Demo.class;

    @Test
    public void reflectConstructor() throws NoSuchMethodException {
        System.out.println(Arrays.toString(klass.getConstructors()));
        System.out.println(Arrays.toString(klass.getDeclaredConstructors()));
        System.out.println(klass.getConstructor(int.class, String.class));
        System.out.println(klass.getDeclaredConstructor());
    }

    @Test
    public void usePublicConstructor() throws Exception {
        Constructor<?> constructor = klass.getConstructor(int.class, String.class);
        // Demo demo = new Demo(10, "hello");
        Demo demo = (Demo) constructor.newInstance(10, "hello");
        demo.sayHello();
    }

    @Test
    public void usePrivateConstructor() throws Exception {
        Constructor<?> constructor = klass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Demo demo = (Demo) constructor.newInstance();
        demo.sayHello();
    }

}

