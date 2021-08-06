package com.pandy.algorithm.dynamic;

/**
 * @Author Pandy
 * @Date 2021/8/7 3:19
 */
public class LCS {
    public static String lcs(String str1, String str2) {
        // 记录最长公共子串的长度
        int maxLength = 0;
        // 记录最长公共子串的最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if (dp[i+1][j+1] > maxLength) {
                        maxLength =dp[i+1][j+1];
                        // 记录最后一个元素的位置
                        maxLastIndex = i;
                    }
                } else {
                    // 两个字符不相等的情况
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return str1.substring(maxLastIndex - maxLength + 1, maxLastIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(lcs("abc", "abd"));
    }

}
