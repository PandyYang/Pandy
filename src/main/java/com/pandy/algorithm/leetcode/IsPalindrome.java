package com.pandy.algorithm.leetcode;

public class IsPalindrome {
    public static boolean isPalindrome(int num) {
        StringBuilder sb = new StringBuilder(num);
        char[] chars = sb.toString().toCharArray();
        int i = 0, j = chars.length - 1;
        int length = String.valueOf(num).length();
        while (i < length/2 && j > length/2) {
            if (chars[i++] == chars[j--]) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean isPalindrome2(int num) {
        // 负数都不是回文
        if (num < 0) return false;


        int cur = 0; //等于是每次取回文最后的数字 再构建一份一样的
        int x = num;
        while (x != 0) {
            cur = cur * 10 + x%10;
            x /= 10;
        }
        return cur == num ;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12321));
    }
}
