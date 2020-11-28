package com.joezhou.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class OneDimensionalArrayTest {
    @Test
    public void build() {
        int[] arrA = new int[]{1, 2, 3};
        int arrB[] = {1, 2, 3};
        int[] arrC = new int[3];
        arrC[0] = 1;
        arrC[1] = 2;
        arrC[2] = 3;
        System.out.println(arrA);
        System.out.println(arrB);
        System.out.println(arrC);
    }

    @Test
    public void traverse() {
        int[] nums = {1, 2, 3};
        for (int i = 0, j = nums.length; i < j; i++) {
            System.out.println(nums[i]);
        }
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void copy() {
        int[] arr = {1, 2, 3};

        int[] arrA = new int[arr.length];
        for (int i = 0, j = arrA.length; i < j; i++) {
            arrA[i] = arr[i];
        }
        System.out.println(Arrays.toString(arrA));

        int[] arrB = new int[arrA.length];
        System.arraycopy(arr, 0, arrB, 0, arr.length);
        System.out.println(Arrays.toString(arrB));

        int[] arrC = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arrC));
    }
    @Test
    public void binarySearch(){
        int target = 13;
        int result = -1;
        int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        int midIndex = (lowIndex + highIndex) / 2;

        while (lowIndex <= highIndex) {

            if (arr[midIndex] == target) {
                result = midIndex;
                break;
            } else {
                if (arr[midIndex] < target) {
                    lowIndex = midIndex + 1;
                } else {
                    highIndex = midIndex - 1;
                }
            }

            midIndex = (lowIndex + highIndex) / 2;
        }
        System.out.println(result);
    }

}