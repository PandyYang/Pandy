package com.pandy.algorithm.leetcode;

/**
 * 前一个字符串中找到后一个字符串出现的第一个位置
 */
public class Str {
    public static int find(String a, String b) {
        if (b == null || b.length() == 0) return 0;
        for (int i = 0; i <= a.toCharArray().length; i++) {
            for (int i1 = 0; i1 <= b.toCharArray().length; i1++) {
                if (a.charAt(i) == b.charAt(i1)) {
                    i++;i1++; continue;
                } else {
                    if (i1 == b.length()) {
                        return i1 - i;
                    }
                }
            }
        }
        return -1;
    }

    public static int find2(String a, String b) {
        if (b.isEmpty()) return 0;
        if (b.length() > a.length()) return -1;
        int j = 0;
        int window = b.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(j)) {
                if (j == window - 1) {
                    return i-window+1;
                }
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find2("hello", "ll"));
    }
}
