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

    /**
     * <h1>4 & 6 过程分析</h1>
     *
     * <p> 00000000 .. 00000100：4原码
     * <p> 00000000 .. 00000100：取反得到4反码，同原码
     * <p> 00000000 .. 00000100：加1得到4补码，同原码
     * <p> 00000000 .. 00000110：6原码
     * <p> 00000000 .. 00000110：取反得到6反码，同原码
     * <p> 00000000 .. 00000110：加1得到6补码，同原码
     * <p> 00000000 .. 00000100：4 & 6结果，有0则0
     * <p> 00000000 .. 00000100：取反得到结果的反码，同原码
     * <p> 00000000 .. 00000100：加1得到结果的补码，同原码
     * <p> 4：真值
     */
    @Test
    public void andOfBit() {
        System.out.println(Integer.toBinaryString(4 & 6));
        System.out.println(4 & 6);
    }

    /**
     * <h1>4 | 6 过程分析</h1>
     *
     * <p> 00000000 .. 00000100：4原码
     * <p> 00000000 .. 00000100：取反得到4反码，同原码
     * <p> 00000000 .. 00000100：加1得到4补码，同原码
     * <p> 00000000 .. 00000110：6原码
     * <p> 00000000 .. 00000110：取反得到6反码，同原码
     * <p> 00000000 .. 00000110：加1得到6补码，同原码
     * <p> 00000000 .. 00000100：4 | 6结果，有1则1
     * <p> 00000000 .. 00000110：取反得到结果的反码，同原码
     * <p> 00000000 .. 00000110：加1得到结果的补码，同原码
     * <p> 6：真值
     */
    @Test
    public void orOfBit() {
        System.out.println(Integer.toBinaryString(4 | 6));
        System.out.println(4 | 6);
    }

    /**
     * <h1> ~4 过程分析</h1>
     *
     * <p> 00000000 .. 00000100：4原码
     * <p> 00000000 .. 00000100：取反得到4反码，同原码
     * <p> 00000000 .. 00000100：加1得到4补码，同原码
     * <p> 11111111 .. 11111011：~4结果，所有位取反，包括符号位
     * <p> 10000000 .. 00000100：取反得到结果的反码
     * <p> 10000000 .. 00000101：加1得到结果的补码
     * <p> -5：真值
     */
    @Test
    public void notOfBit() {
        System.out.println(Integer.toBinaryString(~4));
        System.out.println(~4);
    }

    /**
     * <h1>4 ^ 6 过程分析</h1>
     *
     * <p> 00000000 .. 00000100：4原码
     * <p> 00000000 .. 00000100：取反得到4反码，同原码
     * <p> 00000000 .. 00000100：加1得到4补码，同原码
     * <p> 00000000 .. 00000110：6原码
     * <p> 00000000 .. 00000110：取反得到6反码，同原码
     * <p> 00000000 .. 00000110：加1得到6补码，同原码
     * <p> 00000000 .. 00000010：4 ^ 6结果，无进位相加
     * <p> 00000000 .. 00000010：取反得到结果的反码，同原码
     * <p> 00000000 .. 00000010：加1得到结果的补码，同原码
     * <p> 2：真值
     */
    @Test
    public void xorOfBit() {
        System.out.println(Integer.toBinaryString(4 ^ 6));
        System.out.println(4 ^ 6);
    }

    /**
     * <h1>-2 << 3 过程分析</h1>
     *
     * <p> 10000000 .. 00000010：-2原码
     * <p> 11111111 .. 11111101：取反得到-2反码
     * <p> 11111111 .. 11111110：加1得到-2补码
     * <p> 11111111 .. 11110000：-2 << 3结果，左移动3，溢出忽略，用0补位。
     * <p> 10000000 .. 00001111：取反得到结果的反码
     * <p> 10000000 .. 00010000：加1得到结果的补码
     * <p> -16：真值
     */
    @Test
    public void leftMoveOfBit() {
        System.out.println(Integer.toBinaryString(-2 << 3));
        System.out.println(-2 << 3);
    }

    /**
     * <h1>-2 >> 3 过程分析</h1>
     *
     * <p> 10000000 .. 00000010：-2原码
     * <p> 11111111 .. 11111101：取反得到-2反码
     * <p> 11111111 .. 11111110：加1得到-2补码
     * <p> 11111111 .. 11111111：-2 >> 3结果，右移动3，溢出忽略，用符号位补位。
     * <p> 10000000 .. 00000000：取反得到结果的反码
     * <p> 10000000 .. 00000001：加1得到结果的补码
     * <p> -1：真值
     */
    @Test
    public void rightMoveOfBit() {
        System.out.println(Integer.toBinaryString(-2 >> 3));
        System.out.println(-2 >> 3);
    }

    /**
     * <h1>-2 >>> 3 过程分析</h1>
     *
     * <p> 10000000 .. 00000010：-2原码
     * <p> 11111111 .. 11111101：取反得到-2反码
     * <p> 11111111 .. 11111110：加1得到-2补码
     * <p> 00011111 .. 11111111：-2 >>> 3结果，右移动3，溢出忽略，用0补位。
     * <p> 00011111 .. 11111111：取反得到结果的反码，同原码
     * <p> 10000000 .. 00000001：加1得到结果的补码，同原码
     * <p> 536870911：真值
     */
    @Test
    public void noSignRightMoveOfBit() {
        System.out.println(Integer.toBinaryString(-2 >>> 3));
        System.out.println(-2 >>> 3);
    }
}
