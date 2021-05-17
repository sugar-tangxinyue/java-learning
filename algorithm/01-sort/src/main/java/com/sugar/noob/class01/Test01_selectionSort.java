package com.sugar.noob.class01;

public class Test01_selectionSort {

    public static void main(String[] args) {

        int[] a = {9, 1, 4, 6, 2, 3, 5};
        print(a);
        selectionSort(a);
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
    private static void selectionSort(int[] a) {
        if (null == a || a.length < 2) {
            return;
        }
        int length = a.length;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            maxIndex = i;
            for (int f = i + 1; f < length; f++) {
                maxIndex = a[f] > a[maxIndex] ? f : maxIndex;
            }
            swap(a, i, maxIndex);
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
