package com.joezhou.annotation;

import java.lang.annotation.*;

/**
 * @author JoeZhou
 */
public class CustomAnnotationTest {

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {

        // String name;
        String name();

        // int age = 18;
        int age() default 18;

        // String[] course = {"语文", "数学"}
        String[] course() default {"语文", "数学"};
    }


    @MyAnnotation(name = "赵四")
    private static class Student {

        @MyAnnotation(name = "刘能")
        public void method(){

        }
    }
}
