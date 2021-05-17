package com.sugar.noob.class01;

/**
 * 冒泡排序
 */
public class Test01_BubbleSort {
    public static void main(String[] args) {

        int[] a = {9, 1, 4, 6, 2, 3, 5};
        print(a);
        bubbleSort(a);
        print(a);
    }
    private static void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 选择排序
     * @param a
     */
    private static void bubbleSort(int[] a) {
        if (null == a || a.length < 2) {
            return;
        }
        int length = a.length;
        // 0~n-1
        // 0~n-2
        // 0~n-3
        for (int end = length-1; end >=0; end--) {
            // 0~end
            // 0 1 |1 2|2 3|...|end-1 end|
            for (int f = 0; f < end; f++) {
                if (a[f] > a[f + 1]) {
                    swap(a, f, f + 1);
                }
            }
        }
    }

    /**
     * 位置交换
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
