package com.joezhou.classloader;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author JoeZhou
 */
public class JavaObjectLayoutTest {
    @Test
    public void jol(){
        Object obj = new Object();
        /*
         * line1 - line2 is mark-word message...
         * line3 is class pointer...
         * line4 is padding...
         */
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

}
