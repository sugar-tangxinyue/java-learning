package com.sugar.design.strategy;

public class Sorter {

    public static void sort(Comparable[] arr) {
        if (null == arr || arr.length == 1) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int a = i + 1; a < length; a++) {
                minIndex = arr[a].compareTo(arr[minIndex])>0  ? minIndex : a;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int i, int minIndex) {
        Comparable tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }
}
