package com.joezhou.reflect;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class GetClassTest {
    @Test
    public void getClassMethod() throws ClassNotFoundException {
        GetClassTest instance = new GetClassTest();
        Class<?> classA = instance.getClass();

        Class<?> classB = GetClassTest.class;

        String qualifiedName = "com.joezhou.reflect.GetClassTest";
        Class<?> classC = Class.forName(qualifiedName);

        System.out.println(classA.hashCode());
        System.out.println(classB.hashCode());
        System.out.println(classC.hashCode());
    }
}