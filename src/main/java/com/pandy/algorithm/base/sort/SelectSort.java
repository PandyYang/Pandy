package com.pandy.algorithm.base.sort;

import java.util.Arrays;

/**
 * @Author Pandy
 * @Date 2021/7/22 22:55
 */
public class SelectSort {
    public static int[] select(int[] arr) {
        // 总共需要经过N-1轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数n-i
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(select(new int[]{3, 2, 1})));

    }
}
