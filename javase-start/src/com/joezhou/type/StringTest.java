package com.joezhou.type;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class StringTest {

    @Test
    public void build() {
        String strA = "abc";
        String strB = new String("abc");
        System.out.println(strA);
        System.out.println(strB);
    }

    @Test
    public void compareReference() {
        String str01 = new String("JoeZhou");
        String str02 = new String("JoeZhou");

        // str01 和 str02 有着不同的内存地址，返回F
        System.out.println(str01 == str02);
    }

    @Test
    public void equals() {

    }
}
