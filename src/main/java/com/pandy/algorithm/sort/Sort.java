package com.pandy.algorithm.sort;

public class Sort {

    // 冒泡排序
    // 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
    public static int[] bubbleSort(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

//    public static int[] selectionSort(int[] arr) {
//        if (arr.length == 0) return arr;
//
//    }
}
