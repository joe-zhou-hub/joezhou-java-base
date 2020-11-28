package com.joezhou.calculation;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MathOperatorsTest {

    @Test
    public void base() {
        System.out.println(0 % 2);
        System.out.println(5 % 2);
        System.out.println(5 % -2);
        System.out.println(-5 % 2);
        System.out.println(-5 % -2);
        System.out.println(1 / 0.0);
        System.out.println(1 / 0);
    }

    @Test
    public void numericalOverflow() {
        int maxValueOfInt = 2147483647;
        int result = maxValueOfInt + 1;
        System.out.println(result);
    }

    @Test
    public void andOfBit() {
        System.out.println(Integer.toBinaryString(4 & 6));
        System.out.println(4 & 6);
    }

    @Test
    public void orOfBit() {
        System.out.println(Integer.toBinaryString(4 | 6));
        System.out.println(4 | 6);
    }

    @Test
    public void notOfBit() {
        System.out.println(Integer.toBinaryString(~4));
        System.out.println(~4);
    }

    @Test
    public void xorOfBit() {
        System.out.println(Integer.toBinaryString(4 ^ 6));
        System.out.println(4 ^ 6);
    }

    @Test
    public void leftMoveOfBit() {
        System.out.println(Integer.toBinaryString(-2 << 3));
        System.out.println(-2 << 3);
    }

    @Test
    public void rightMoveOfBit() {
        System.out.println(Integer.toBinaryString(-2 >> 3));
        System.out.println(-2 >> 3);
    }

    @Test
    public void noSignRightMoveOfBit() {
        System.out.println(Integer.toBinaryString(-2 >>> 3));
        System.out.println(-2 >>> 3);
    }
}
