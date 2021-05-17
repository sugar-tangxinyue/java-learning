package com.sugar.basic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class Code02_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9, 4, 5, 7, 8, 5, 7, 6, 8};
        selectionSort(arr);
        test(arr);
    }

    private static void test(int[] arr) {
        Arrays.sort(arr);
        System.out.println("++++++++++++++++++++++");
        for (int i : arr) {
            System.out.println(i);
        }

    }

    /**
     * 排序
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        if (null == arr || arr.length == 1) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int a = i; a < length - i; a++) {
                if (a + 1 < length - i) {
                    if (arr[a] > arr[a + 1]) {
                        swap(arr, a, a + 1);
                    }
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 排序
     * @param arr
     */
    private static void selectionSort2(int[] arr) {
        if (null == arr || arr.length == 1) {
            return;
        }
        int length = arr.length;
        for (int i = length - 1; i > 0; i--) {
            for (int a = 0; a < i; a++) {
                if (arr[a] > arr[a + 1]) {
                    swap(arr, a, a + 1);
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 位置交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 位置交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
