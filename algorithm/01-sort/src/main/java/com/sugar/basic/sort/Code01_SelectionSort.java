package com.sugar.basic.sort;

import java.util.Arrays;

/**
 * 选择排序
 *     第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 *     然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 *     以此类推，直到全部待排序的数据元素的个数为零。
 *     选择排序是不稳定的排序方法
 */
public class Code01_SelectionSort {

    public static void main(String[] args) {
        int[] arr={9,4,5,7,8,5,7,6,8};
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

    private static void selectionSort(int[] arr) {
        if(null==arr||arr.length==1){
            return;
        }
        int length=arr.length;
        for(int i=0;i<length;i++){
            int minIndex=i;
            for(int a=i+1;a<length;a++){
                minIndex=arr[a]>arr[minIndex]?minIndex:a;
            }
           swap(arr,i,minIndex);
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int tmp=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=tmp;
    }


}
