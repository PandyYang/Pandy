package com.pandy.algorithm.base.sort;

/**
 * @Author Pandy
 * @Date 2021/7/22 23:04
 */
public class InsertSort {
    public static int[] insert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];

            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
