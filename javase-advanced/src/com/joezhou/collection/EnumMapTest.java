package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * @author JoeZhou
 */
public class EnumMapTest {

    private enum Color {
        /**
         * some color
         */
        RED, GREEN, BLUE, YELLOW, WHITE, BLACK, PINK, GRAY
    }

    private EnumMap<Color, String> enumMap;

    @Before
    public void before() {
        enumMap = new EnumMap<>(Color.class);
    }

    @Test
    public void enumMap() {
        enumMap.put(Color.RED, "red");
        enumMap.put(Color.GREEN, "green");
        enumMap.put(Color.BLUE, "blue");
        enumMap.put(Color.YELLOW, "yellow");
        enumMap.put(Color.WHITE, "white");
        enumMap.put(Color.BLACK, "black");
        enumMap.put(Color.PINK, "pink");
        enumMap.put(Color.GRAY, "gray");

        Set<Map.Entry<Color, String>> colors = enumMap.entrySet();
        for (Map.Entry<Color, String> e : colors) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

}



