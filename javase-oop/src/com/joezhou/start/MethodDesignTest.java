package com.joezhou.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MethodDesignTest {
    private int addNum(int numA, int numB) {
        return numA + numB;
    }

    @Test
    public void addNum() {
        int result = addNum(1, 5);
        System.out.println(result);
    }
}
