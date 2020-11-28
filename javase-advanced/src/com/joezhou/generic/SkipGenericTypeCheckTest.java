package com.joezhou.generic;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author JoeZhou
 */
public class SkipGenericTypeCheckTest {

    private static class Demo<T> {
        private T value;

        void setValue(T value) {
            this.value = value;
        }

        void printValue(){
            System.out.println(value);
        }
    }

    @Test
    public void skipGenericTypeCheckByReflect() throws Exception {
        Demo<String> demo = new Demo<>();
        // demo.setValue(10);// compile fail
        Class<?> klass = demo.getClass();
        Method method = klass.getDeclaredMethod("setValue", Object.class);
        method.invoke(demo, 10);
        demo.printValue();
    }
}