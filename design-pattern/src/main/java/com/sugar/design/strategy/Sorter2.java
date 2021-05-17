package com.sugar.design.strategy;

public class Sorter2<T> {

    public void sort(T[] arr, Comparator<T> comparator) {
        if (null == arr || arr.length == 1) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int a = i + 1; a < length; a++) {
                minIndex = comparator.compare(arr[a], arr[minIndex]) > 0 ? minIndex : a;
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(T[] arr, int i, int minIndex) {
        T tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }
}
