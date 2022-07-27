package com.pandy.algorithm.base.sort;

import java.util.Arrays;

/**
 * @Author Pandy
 * @Date 2021/7/22 22:49
 */
public class BubbleSort {
    public static int[] bubble(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubble(new int[]{3, 2, 1})));
    }
}
