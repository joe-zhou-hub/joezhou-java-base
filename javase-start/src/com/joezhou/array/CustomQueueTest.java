package com.joezhou.array;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CustomQueueTest {

    private int[] arr = {1, 2, 3};

    @Test
    public void add() {
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
    public void poll() {
        int firstElement = arr[0];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = newArr.length; i < j; i++) {
            newArr[i] = arr[i + 1];
        }
        arr = newArr;
        System.out.println("poll: " + firstElement);
        for (int e : arr) {
            System.out.print(e + "\t");
        }
    }

    @Test
    public void peek() {
        System.out.println(arr.length <= 0 ? null : arr[0]);
    }
}
