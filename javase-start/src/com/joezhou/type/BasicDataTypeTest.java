package com.joezhou.type;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class BasicDataTypeTest {

    @Test
    public void build() {
        byte byteNum = 100;
        System.out.println(byteNum);

        short shortNum = 100;
        System.out.println(shortNum);

        int intNum = 100;
        System.out.println(intNum);

        long longNum = 100L;
        System.out.println(longNum);

        float floatNum = 100.0F;
        System.out.println(floatNum);

        double doubleNum = 100.0;
        System.out.println(doubleNum);

        boolean flag = false;
        System.out.println(flag);

        char character = 'A';
        System.out.println(character);
    }
}
