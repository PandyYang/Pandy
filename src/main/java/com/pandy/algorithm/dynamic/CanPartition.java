package com.pandy.algorithm.dynamic;

/**
 * leetcode 416
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) sum += num;

        if ((sum & 1) == 1) return false;

        int target = sum >> 1;

        int length = nums.length; // 元素的总长度

        int[][] dp = new int[length + 1][target + 1];

        // 背包中元素的最大和是sum/2
        for (int i = 1; i <= length; i++) {
            for (int i1 = 1; i1 <= target; i1++) {
                if (i1 > nums[i - 1]) {
                    dp[i][i1] = Math.max(dp[i - 1][i1], dp[i - 1][i1 - nums[i - 1]]) + nums[i - 1];
                } else {
                    dp[i][i1] = dp[i - 1][i1];
                }
            }
        }
        return dp[length][target] == target;

    }
}
