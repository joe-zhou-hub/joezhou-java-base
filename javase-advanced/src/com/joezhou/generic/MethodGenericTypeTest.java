package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MethodGenericTypeTest<T> {

	private static <V> V method(V v) {
        String result =
                v instanceof Integer ? "type of Integer" :
                v instanceof Double ? "type of Double" :
                v instanceof String ? "type of String" : "type of Others";
        System.out.println("the param is " + result);
        return v;
    }

    @Test
    public void methodGenericType() {
        Integer resultA = MethodGenericTypeTest.method(15);
        Double resultB = MethodGenericTypeTest.method(15.0);
        String resultC = MethodGenericTypeTest.method("15.0");
        System.out.println(resultA + ", " + resultB + ", " + resultC);
    }
}