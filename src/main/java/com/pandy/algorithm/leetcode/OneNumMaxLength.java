package com.pandy.algorithm.leetcode;

/**
 * 二进制数组中连续1的最大长度
 */
public class OneNumMaxLength {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1};
        int res = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count ++;
            } else {
                res = Math.max(count, res);
                count = 0;
            }
        }
        System.out.println(Math.max(res, count));
    }
}
