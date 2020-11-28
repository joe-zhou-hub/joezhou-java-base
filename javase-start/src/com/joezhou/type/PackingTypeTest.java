package com.joezhou.type;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class PackingTypeTest {

    @Test
    public void build() {
        System.out.println(new Byte((byte) 100));
        System.out.println(new Short((short) 200));
        System.out.println(new Integer(10000));
        System.out.println(new Long(10000000L));
        System.out.println(new Double(12.5));
        System.out.println(new Float(12.5F));
        System.out.println(new Character('a'));

        // System.out.println(new Boolean(true));
        // Boolean类型包装了更建议的一种声明方式
        System.out.println(Boolean.TRUE);
    }

    @Test
    public void manualBoxing() {
        int num  = 10;
        Integer result = Integer.valueOf(num);
        System.out.println(result);
    }

    @Test
    public void manualUnBoxing() {
        Integer num = new Integer(10);
        int result = num.intValue();
        System.out.println(result);
    }
}
