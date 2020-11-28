package com.joezhou.collection;

import org.junit.Test;

import java.util.EnumSet;

/**
 * @author JoeZhou
 */
public class EnumSetTest {

    private enum Color {
        /**
         * some color
         */
        RED, GREEN, BLUE, YELLOW, WHITE, BLACK, PINK, GRAY
    }

    @Test
    public void enumToSet() {
        EnumSet<Color> colors = EnumSet.allOf(Color.class);
        for (Color color : colors) {
            System.out.print(color.toString() + "\0");
        }
    }
}
