package com.pandy.algorithm.geek.reverselist;

import java.util.Arrays;

/**
 * @author Pandy
 * 寻找数组的中心下标
 */
public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum = sum - nums[i];//求出
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 2, 3, 4, 2, 4}));
    }
}
