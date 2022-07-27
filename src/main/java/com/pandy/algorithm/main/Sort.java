package com.pandy.algorithm.main;

import java.util.Arrays;

/**
 * @author Pandy
 */
class Sort {

    // 二分查找非递归实现
    private static int search(int[] data, int l, int r, int target) {
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    // 二分查找递归实现
    private static int searchDfs(int[] data, int l, int r, int target) {
        if (l >= r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (target == data[mid]) {
            return mid;
        } else if (target > data[mid]) {
            return searchDfs(data, mid + 1, r, target);
        } else {
            return searchDfs(data, l, mid, target);
        }
    }

    public static void QuickSort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int p = partition(arr, l, r);
        QuickSort(arr, l, p - 1);
        QuickSort(arr, p + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() % (r - l + 1) + l));
        int v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int partition = partition(new int[]{2, 1, 3, 4}, 0, 3);
        System.out.println("partition = " + partition);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    // 动态规划处理斐波那契数列
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
