package com.pandy.algorithm.offer.question;

import java.util.ArrayList;

/**
 * 升序查找两个数字和为sum  若出现多个取乘积最大的一个
 * 左右指针遍历 最靠近两端的是乘积最大的
 */
public class FindNumberWithSum {
    public ArrayList<Integer> find(int[] arr, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null) return list;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int s = arr[left] + arr[right];
            if (s == sum) {
                list.add(arr[left]);
                list.add(arr[right]);
                return list;
            } else {
                if (s > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
