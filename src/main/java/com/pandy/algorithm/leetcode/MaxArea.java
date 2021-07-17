package com.pandy.algorithm.leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        int capacity = 0;
        int l = 0, r= height.length - 1;
        while (l < r) {
            // 取左右最短的高度进行比较 乘以下面长度
            capacity = Math.max(Math.min(height[l], height[r]) * (r - l), capacity);
            if(height[l] <= height[r]) l++; else r--;
        }
        return capacity;
    }
}
