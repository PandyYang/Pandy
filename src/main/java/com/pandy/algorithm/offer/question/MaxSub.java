package com.pandy.algorithm.offer.question;

/**
 * 数组中和最大的子串
 */
public class MaxSub {
    // 求最大的子串问题一般是定义一个和变量 求出每一个阶段的和sum 和存储现在发现的最长的和res
    // 遇见负数 把当前元素值为和 否则累积 每次循环求出已知遍历的最大的和res
    public static int sub(int[] arr) {
        int res = arr[0];
        int sum = 0;
        for (int i1 : arr) {
            if (i1 < 0) {
                sum = i1;
            } else {
                sum += i1;
            }
            res = Math.max(sum,  res);
        }
        return res;
    }
}
