package com.joezhou.enumclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CustomEnumTest {

    @Test
    public void rgbColorTest() {
        System.out.println(RgbColor.RED.getRgb());
    }
}

enum RgbColor {

    /**
     * RGB三原色
     */
    RED(1), GREEN(2), BLUE(3);

    private int rgbCode;

    RgbColor(int rgbCode) {
        this.rgbCode = rgbCode;
    }

    public int getRgb() {
        return rgbCode;
    }
}

