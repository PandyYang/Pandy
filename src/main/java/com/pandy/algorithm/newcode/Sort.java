package com.pandy.algorithm.newcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sort {
    public static int[] MySort(int[] arr) {
        // write code here
        if (arr.length <= 1) {
            return arr;
        }
        /**
         * 冒泡
         * 最佳情况T(n) = O(n)
         * 最差情况：T(n) = O(n2)
         * 平均情况：T(n) = O(n2)
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     */
    public static int[] choose(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] MergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid + 1, arr.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, j = 0, index = 0; i < result.length; i++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = new int[]{2, 3, 1, 5, 3, 2};
        choose(res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] MySort2(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = queue.poll();
        }
        return newArr;
    }
}
