package com.joezhou.array;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CustomStackTest {

    private int[] arr = {1, 2, 3};

    @Test
    public void push() {
        int element = 10;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = arr.length; i < j; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = element;
        arr = newArr;
        for (int e : arr) {
            System.out.print(e + "\t");
        }
    }

    @Test
    public void pop() {
        int lastElement = arr[arr.length - 1];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = newArr.length; i < j; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("pop: " + lastElement);
        for (int e : arr) {
            System.out.print(e + "\t");
        }
    }

    @Test
    public void peek() {
        System.out.println(arr[arr.length - 1]);
    }
}
