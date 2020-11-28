package com.joezhou.array;

import org.junit.Test;

import java.util.BitSet;

/**
 * @author JoeZhou
 */
public class BitSetTest {
    @Test
    public void api() {
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(12);
        System.out.println(bitSet.size());
        bitSet.set(64);
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(500));
        System.out.println(bitSet.size());
    }

    @Test
    public void work01() {
        BitSet bitSet = new BitSet(365);
        int[] holidays = {1, 15, 50, 148, 185, 246, 281, 316, 326, 359};
        for (int holiday : holidays) {
            bitSet.set(holiday);
        };
        System.out.println(bitSet.get(1) ? "is holiday" : "is not holiday");
        System.out.println(bitSet.get(2) ? "is holiday" : "is not holiday");
    }
}
