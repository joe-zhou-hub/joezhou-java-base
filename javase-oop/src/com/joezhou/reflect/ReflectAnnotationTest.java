package com.joezhou.reflect;

import org.junit.Test;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class ReflectAnnotationTest {

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String name();

        int age() default 18;

        String[] course() default {"语文", "数学"};
    }

    @MyAnnotation(name = "赵四")
    static class Student {

        @MyAnnotation(name = "刘能")
        public void method() {
        }
    }

    @Test
    public void reflectAnnotation() {
        Class<?> klass = Student.class;
        MyAnnotation annotation = klass.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(annotation.age());
        System.out.println(annotation.name());
        System.out.println(Arrays.toString(annotation.course()));
    }
}
