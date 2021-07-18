package com.pandy.algorithm.leetcode;

/**
 * @Author Pandy
 * @Date 2021/7/18 9:54
 * 正则表达式匹配
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        if (p == null) {
            if (s == null) {
                return true;
            } else {
                return false;
            }
        }

        if (s == null && p.length() == 1) return false;

        int m = s.length() + 1;
        int n = p.length() + 1;

        boolean[][] dp = new boolean[m][n];

        dp[0][0] = true;

        for (int i = 2; i < n; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int r = 1; r < m; r++) {
            int i = r - 1;
            for (int c = 1; c < n; c++) {
                int j = c - 1;
                if (s.charAt(i) == p.charAt(j) || p.charAt(j-1) == '.') {
                    dp[r][c] = dp[r-1][c-1];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        dp[r][c] = dp[r-1][c] || dp[r][c-2];
                    } else {
                        dp[r][c] = dp[r][c-2];
                    }
                } else {
                    dp[r][c] = false;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
