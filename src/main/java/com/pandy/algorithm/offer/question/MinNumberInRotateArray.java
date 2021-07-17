package com.pandy.algorithm.offer.question;

public class MinNumberInRotateArray {
    public static int min(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high)/2;
            if (arr[mid] > arr[high]) {
                low = mid + 1; // 小数字在右边
            } else if (arr[mid] == arr[high]) {
                high = high - 1;
            }else {
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        System.out.println(min(new int[]{4, 5, 6, 1, 2, 3}));
    }

    public int binarySearch(int arr[], int key) {
        int low = 0;
        int high = arr.length-1;
        int middle = 0;
        while (low < high) {
            middle = (low + high) /2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
