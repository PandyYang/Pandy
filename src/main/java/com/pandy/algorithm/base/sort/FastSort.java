package com.pandy.algorithm.base.sort;

/**
 * @Author Pandy
 * @Date 2021/7/23 0:10
 */
public class FastSort {
    private static void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }

                if (i < j) {
                    src[i] = src[j];
                    i++;
                }

                while (i < j && src[i] < key) {
                    i++;
                }

                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
}
