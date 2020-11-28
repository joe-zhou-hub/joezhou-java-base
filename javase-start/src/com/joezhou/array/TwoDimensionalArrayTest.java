package com.joezhou.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class TwoDimensionalArrayTest {

    @Test
    public void build() {
        int[][] arrA = new int[][]{{1}, {4, 67}, {80}};
        System.out.println(Arrays.deepToString(arrA));

        int[] arrB[] = {{1}, {4, 67}, {80}};
        System.out.println(Arrays.deepToString(arrB));

        int[][] arrC = new int[2][3];
        arrC[0][0] = 1;
        arrC[0][1] = 22;
        arrC[0][2] = 313;
        arrC[1][0] = 34;
        arrC[1][1] = 311;
        arrC[1][2] = 35;
        System.out.println(Arrays.deepToString(arrC));
    }

    @Test
    public void traverse() {
        int[][] arr = {{1}, {4, 67}, {5}, {16, 17, 18, 40}};
        for (int i = 0, j = arr.length; i < j; i++) {
            for (int m = 0; m < arr[i].length; m++) {
                System.out.print(arr[i][m] + "\t");
            }
        }
        for (int[] e1 : arr) {
            for (int e2 : e1) {
                System.out.print(e2 + "\t");
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}