package com.joezhou.enumclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class EnumApiTest {
    @Test
    public void api() {
        System.out.println(EnumDemo.ONE.toString());
        System.out.println(EnumDemo.SIX.name());
        System.out.println(EnumDemo.FOR.ordinal());
        System.out.println(EnumDemo.TWO.compareTo(EnumDemo.FIV));
        for (EnumDemo e : EnumDemo.values()) {
            System.out.print(e.toString() + "\t");
        }
    }
}

enum EnumDemo{
    /**1到6*/
    ONE, TWO, THR, FOR, FIV, SIX;
}
