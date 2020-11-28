package com.joezhou.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class VariableTest {

    @Test
    public void declaration() {
        int numA;
        int numB, numC;
    }

    @Test
    public void assignment() {
        int numA;
        int numB = 20, numC = 30;
        numA = 10;
        System.out.println(numA);
        System.out.println(numB);
        System.out.println(numC);
    }
}
