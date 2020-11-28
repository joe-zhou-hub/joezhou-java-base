package com.joezhou.start;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class MethodParamsTest {

    private void methodA(int num) {
        num = 1000;
    }

    private void methodB(int[] arr) {
        arr[0] = 1000;
    }

    @Test
    public void passCopy() {
        int num = 10;
        methodA(num);
        System.out.println(num);
    }

    @Test
    public void passReference() {
        int[] arr = {1, 2};
        methodB(arr);
        System.out.println(Arrays.toString(arr));
    }
}
