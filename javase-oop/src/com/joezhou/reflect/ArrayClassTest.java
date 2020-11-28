package com.joezhou.reflect;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ArrayClassTest {
    @Test
    public void arrayTypeTest() {
        Class<?> classA = int[].class;
        Class<?> classB = int[][][].class;
        Class<?> classC = double[].class;
        System.out.println(classA.hashCode());
        System.out.println(classB.hashCode());
        System.out.println(classC.hashCode());
    }
}
