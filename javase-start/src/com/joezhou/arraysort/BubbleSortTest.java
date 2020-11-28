package com.joezhou.arraysort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class BubbleSortTest {
    @Test
    public void bubbleSort(){
        int[] arr = { 101, 2, 23, 133, 412, 23, 412, 51, 235 };

        // 每一轮：9个数，两两相比，要比9-1轮
        for (int i = 0, j = arr.length - 1; i < j; i++) {

            // 相邻两个数比较，需要比较length-1-i次
            for (int m = 0, n = arr.length - 1 - i; m < n; m++) {

                // 前数大于后数就交换，循环一次完毕保证最大的数排最后
                if (arr[m] > arr[m + 1]) {
                    int temp = arr[m];
                    arr[m] = arr[m + 1];
                    arr[m + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
