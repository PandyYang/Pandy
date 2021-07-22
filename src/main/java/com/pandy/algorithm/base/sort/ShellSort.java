package com.pandy.algorithm.base.sort;

/**
 * @Author Pandy
 * @Date 2021/7/22 23:52
 */
public class ShellSort {
    public static void shell(int[] arr) {
        int len = arr.length;
        int temp;
        for(int step = len/2; step >= 1; step /= 2) {
            for (int i = step; i < len; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j+step] = arr[j];
                    j -= step;
                }
                arr[j+step] = temp;
            }
        }
    }
}
