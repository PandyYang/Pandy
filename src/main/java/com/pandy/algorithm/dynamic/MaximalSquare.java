package com.pandy.algorithm.dynamic;

/**
 * @Author Pandy
 * @Date 2021/8/7 3:00
 * 求只包含1的最大正方形 并返回其面积
 */
public class MaximalSquare {
    public int max(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height + 1][width+1];
        // 最大正方形的宽
        int maxSide = 0;
        for (int i = 1; i <= height ; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
