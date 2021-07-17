package com.pandy.algorithm.leetcode100;

/**
 * @author Pandy
 * 让字符串 \textit{needle}needle 与字符串 \textit{haystack}haystack 的所有长度为 mm 的子串均匹配一次。
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
