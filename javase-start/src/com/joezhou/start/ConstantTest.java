package com.joezhou.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ConstantTest {

    @Test
    public void constant() {
        System.out.println(100);
        System.out.println("hello");
        final int num = 200;
        // num = 500;
        System.out.println(num);
    }

    @Test
    public void scientificNotation() {
        System.out.println(1.23e5);
        System.out.println(1.23E5);
        System.out.println(12.3E4);
        System.out.println(0.123E6);
    }

    @Test
    public void toBinaryString() {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));
    }

    @Test
    public void octalNumber() {
        System.out.println(0123);
        System.out.println(-0123);
    }

    @Test
    public void hexadecimalNumber() {
        System.out.println(0x123);
        System.out.println(-0x123);
        System.out.println(0X123);
        System.out.println(-0X123);
    }
}
