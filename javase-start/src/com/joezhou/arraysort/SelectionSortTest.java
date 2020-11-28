package com.joezhou.arraysort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class SelectionSortTest {
    @Test
    public void selectionSort(){
        int[] arr = { 101, 2, 23, 133, 412, 23, 412, 51, 235 };

        // 每轮都将确定将一个无序区中最小的元素追加到有序区，需要比较N-1次
        for (int i = 0, j = arr.length - 1; i < j; i++) {

            // 每一次都拿一个元素和后面所有的元素进行比较
            for (int m = i + 1, n = arr.length; m < n; m++) {

                // 只要比arr[x]小，arr[x]就将其抢夺，最终arr[x]一定是无序区最小的元素
                if (arr[i] < arr[m]) {
                    int temp = arr[i];
                    arr[i] = arr[m];
                    arr[m] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
