package com.joezhou.gc;


import org.junit.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

/**
 * @author JoeZhou
 */
public class GarbageCollectorTest {
    @Test
    public void myGarbageCollector() {
        for (GarbageCollectorMXBean e : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println(e.getName());
        }
    }
}