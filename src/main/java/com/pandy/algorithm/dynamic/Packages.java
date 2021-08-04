package com.pandy.algorithm.dynamic;

/**
 * 背包问题
 * N件物品和一个容量为V的包，第i件物品的重量是w[i] 价值是v[i]
 * 求将哪些物品放入背包可以使这些物品的重量总和不能超过背包容量
 * 且价值总和最大。
 */
public class Packages {

    public static int packageProblem() {

        // 包最大可装重量
        int maxWeight = 4;

        // 三个物品的重量
        int[] weight = {1, 4, 3};

        // 三个物品的价值
        int[] value = {150, 300, 200};

        int[][] dp = new int[weight.length - 1][maxWeight + 1];

        for (int i = 1; i < value.length; i++) {
            // 表示剩余容量能装入当前物品的重量
            for (int j = 1; j < maxWeight; j++) {
                if (j >= weight[i-1]) {
                    // 当前商品的价值 + 剩余空间可容纳的价值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    // 不选当前商品
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length][maxWeight];
    }
}
