package com.joezhou.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author JoeZhou
 */
public class ReflectPerformanceTest {
    private Long testTimes = 1000000000L;

    static class User {
        private int age;

        public void hello() {
            age++;
        }
    }

    @Test
    public void normalPerformance() {
        User user = new User();
        for (int i = 0; i < testTimes; i++) {
            user.hello();
        }
        System.out.println("普通方法调用完毕...");
    }

    @Test
    public void reflectPerformance() throws Exception {
        User user = new User();
        Method method = user.getClass().getDeclaredMethod("hello");
        for (int i = 0; i < testTimes; i++) {
            method.invoke(user);
        }
        System.out.println("没开启setAccessible方法的反射调用完毕...");
    }

    @Test
    public void reflectWithAccessPerformance() throws Exception {
        User user = new User();
        Method method = user.getClass().getDeclaredMethod("hello");
        method.setAccessible(true);
        for (int i = 0; i < testTimes; i++) {
            method.invoke(user);
        }
        System.out.println("开启了setAccessible方法的反射调用完毕...");
    }
}