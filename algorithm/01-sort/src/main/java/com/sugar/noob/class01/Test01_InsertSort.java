package com.sugar.noob.class01;

/**
 * 插入排序
 */
public class Test01_InsertSort {
    public static void main(String[] args) {

        int[] a = {9, 1, 4, 6, 5, 3, 4, 2, 3, 5};
        print(a);
//        isnertSort(a);
        isnertSort02(a);
        print(a);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void isnertSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int length = arr.length;
        int a = 0;
        // 0~0
        // 0~1
        // 0~n-1
        for (int i = 1; i < length; i++) {
            // 0~end
            // i i-1|i-1 i-2|i-2 i-3
            int newIndex = i;
            while (newIndex - 1 >= 0 && arr[newIndex - 1] > arr[newIndex]) {
                swap(arr, newIndex - 1, newIndex);
                newIndex--;
                a++;
            }
        }
        System.out.println(a);
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void isnertSort02(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int length = arr.length;
        int a = 0;
        // 0~0
        // 0~1
        // 0~n-1
        for (int i = 1; i < length; i++) {
            // 0~end
            // i i-1|i-1 i-2|i-2 i-3
            for (int f = i; f > 0; f--) {
                if (arr[f] >= arr[f - 1]) {
                    break;
                }
                swap(arr, f, f - 1);
                a++;
            }

        }
        System.out.println(a);
    }

    /**
     * 位置交换
     *
     * @param a
     * @param i
     * @param maxIndex
     */
    private static void swap(int[] a, int i, int maxIndex) {
        int tmp = a[i];
        a[i] = a[maxIndex];
        a[maxIndex] = tmp;
    }
}
