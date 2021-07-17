package com.pandy.algorithm.leetcode;

/**
 * 爬楼梯
 * 斐波那契数列问题
 */
public class ClimbStairs {
    public int climb(int n) {
        int first = 1;
        int second = 2;
        int temp;

        if (n == 1) {
            return first;
        }

        if (n == 2) {
            return second;
        }

        for (int i = 2; i <= n; i++) {
            temp = first;
            first = second;
            second = temp + second;
        }
        return second;
    }
}
