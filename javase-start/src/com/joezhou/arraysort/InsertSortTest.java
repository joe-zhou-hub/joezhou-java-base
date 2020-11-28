package com.joezhou.arraysort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class InsertSortTest {
    @Test
    public void insertSort() {
        int[] arr = {101, 2, 23, 133, 412, 23, 412, 51, 235};

        // 从第i个位置开始依次向前比较，i从1开始，因为第0个人无法和它前面的人进行比较
        // 由于你的i是从1开始的，所以判断条件要改为i<arrs.length，不能使用length-1，否则会少比一次
        for (int i = 1, j = arr.length; i < j; i++) {

            // 角标为1的人（第二个人），最多需要向前比较1次
            // 角标为2的人（第三个人），最多需要向前比较2次
            // 角标为i的人（第i+1个人），最多需要向前比较i次，所以m = i ; m > 0 ; m--
            for (int m = i; m > 0; m--) {

                // 若后面的数小，交换，若后面的数大，直接结束循环，没有再向前比较的必要
                if (arr[m] < arr[m - 1]) {
                    int temp = arr[m];
                    arr[m] = arr[m - 1];
                    arr[m - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
