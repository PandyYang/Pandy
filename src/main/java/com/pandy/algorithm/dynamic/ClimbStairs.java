package com.pandy.algorithm.dynamic;

/**
 * @Author Pandy
 * @Date 2021/7/28 21:49
 */
public class ClimbStairs {
    public int test(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 2; i < n; i++) {
            int cur = first + second;
            first = second;
            second = cur;
        }
        return second;
    }
}
