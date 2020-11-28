package com.joezhou.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MyClassTest {
    public int id = 1;
    String name = "张三";
    public static int age = 23;
    private String gender = "女";

    @Test
    public void instance() {
        MyClassTest zhaosi = new MyClassTest();
        System.out.println(zhaosi);
    }

    @Test
    public void changeForNoStaticField() {
        MyClassTest zhaosi = new MyClassTest();
        MyClassTest liuneng = new MyClassTest();
        zhaosi.id = 50;
        System.out.println(liuneng.id);
    }

    @Test
    public void changeForStaticField() {
        MyClassTest zhaosi = new MyClassTest();
        MyClassTest liuneng = new MyClassTest();
        MyClassTest.age = 50;
        System.out.println(MyClassTest.age);
    }
}