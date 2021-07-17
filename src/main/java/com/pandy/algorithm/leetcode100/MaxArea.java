package com.pandy.algorithm.leetcode100;

/**
 * @author Pandy
 * 双指针法求解装最多水的容器
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int ans = 0;
        while (low < high) {
            int area = Math.min(height[low], height[high]) * (high - low);
            ans = Math.max(area, ans);
            if (height[low] < height[high]) {
                ++low;
            } else {
                --high;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
