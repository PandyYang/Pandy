package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class MaxLenHuiWen {
    public static int maxLongHuiwen(String str) {
        //等价于求str字符串的逆序字符串和str的最长公共子串，动态
        String strrev = new StringBuilder(str).reverse().toString();
        int len = str.length();
        int[][] dp = new int[len + 1][len + 1];
        int max = 0; //记录最长公共子串的长度
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (str.charAt(i - 1) == strrev.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = 0;
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            System.out.println(maxLongHuiwen(str));
        }
        in.close();
    }

    public static int getNumber(String str) {
        int result = 1;
        //将字符串反转
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        //获取所有子串，查看翻转后的字符串是否包含该子串
        for (int i = temp.length(); i >= 1; i--) { // 降序
            //i为子串的长度
            for (int j = 0; j <= temp.length() - i; j++) { // 升序
                // 子串长度
                String tempSubString = temp.substring(j, j + i);
                // 判断是否包含串子串
                if (str.contains(tempSubString)) {
                    return i;
                }
            }
        }
        return result;
    }
}
