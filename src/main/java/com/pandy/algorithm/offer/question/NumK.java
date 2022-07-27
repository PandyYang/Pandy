package com.pandy.algorithm.offer.question;

import java.util.Arrays;

/**
 * 找出数组中指定元素出现的次数
 */
public class NumK {
    public int findK(int[] arr, int k) {
        int res = 0;
        int mid = arr.length / 2;
        if (k < arr[mid]) {
            // k在左边 递归寻找
            res += findK(Arrays.copyOfRange(arr, 0, mid), k);
        } else if (k > arr[mid]) {
            // k在右边递归寻找
            res += findK(Arrays.copyOfRange(arr, mid, arr.length), k);
        } else {
            // 从找到位置向右遍历
            for (int i = mid; i < arr.length; i++) {
                if (arr[i] == k) {
                    res++;
                } else {
                    break;
                }
            }

            // 从找到位置向左遍历
            for (int i = mid - 1; i >= 0; i--) {
                if (arr[i] == mid) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
