package com.joezhou.enumclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class EnumInSwitchTest {
    @Test
    public void enumForSwitch() {
        Week dayOfWeek = Week.SAT;
        switch (dayOfWeek) {
            case SAT:
                System.out.println("复习..");
                break;
            case SUN:
                System.out.println("旅游..");
                break;
            default:
                System.out.println("上课..");
                break;
        }
    }
}
