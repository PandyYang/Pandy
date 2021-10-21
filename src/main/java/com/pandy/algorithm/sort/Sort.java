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

    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i,j,x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x) // 从右往左找第一个小于x的数
                    j--;
                if (i < j) // 找到 则调换该数顺序
                    a[i++] = a[j];
                while (i < j && a[i] < x) // 从左往右找第一个大于x的值
                    i++;
                a[j--] = a[i];
            }
            a[i] = x; // x 是
            quickSort(a, l, i-1);
            quickSort(a, i+1, r);
        }
    }

    public static void main(String[] args) {
        int []arr = {2,1,5,3,4};
        quickSort(arr, 0, 4);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
}
