package com.pandy.algorithm.leetcode100;

/**
 * @author Pandy
 * 动态规划求解最长回文串
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        //dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化 所有长度为1的子串都是回文串 也就是表格的对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 递推开始 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界 左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                int j = L + i - 1; // j为右边界的坐标
                if (j >= len) break; // 右边越界 退出循环

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 只要dp[i][j] == true成立 就表示s[i..L]是回文 此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j- i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 暴力解法
    public static String longestPalindrome2(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1;  j<= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    // 判断是否为回文
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i< len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babab"));
        System.out.println(longestPalindrome2("asdasddbabab2"));
    }
}
