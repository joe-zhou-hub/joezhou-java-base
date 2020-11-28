package com.joezhou.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class ReflectFieldTest {
    private Class<?> klass = Demo.class;

    static class Demo {
        public String name;
        private int gender = 0;
    }

    @Test
    public void reflectField() throws NoSuchFieldException {
        System.out.println(Arrays.toString(klass.getFields()));
        System.out.println(Arrays.toString(klass.getDeclaredFields()));
        System.out.println(klass.getField("name"));
        System.out.println(klass.getDeclaredField("gender"));
    }

    @Test
    public void usePublicField() throws Exception {
        // FieldTest instanceA = new FieldTest();
        // FieldTest instanceB = new FieldTest();
        Object instanceA = klass.getDeclaredConstructor().newInstance();
        Object instanceB = klass.getDeclaredConstructor().newInstance();

        Field nameField = klass.getField("name");

        // instanceA.name = "赵四"
        // instanceB.name = "刘能"
        nameField.set(instanceA, "赵四");
        nameField.set(instanceB, "刘能");

        // instanceA.name
        // instanceB.name
        System.out.println(nameField.get(instanceA));
        System.out.println(nameField.get(instanceB));
    }

    @Test
    public void usePrivateField() throws Exception {
        Object instance = klass.getDeclaredConstructor().newInstance();
        Field ageField = klass.getDeclaredField("gender");
        ageField.setAccessible(true);
        ageField.setInt(instance, 0);
        System.out.println(ageField.get(instance));
    }

}