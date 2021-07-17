package com.pandy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

// 滑动窗口while i j ans n等参数都需要
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int j = 0, i = 0;
        int n = s.length();
        while (i < n && j < n) {
            // 使用set判断有没有重复的元素 适合用来滑动没有重复元素的窗口
            if (!set.contains(s.charAt(j))) {
                // 没有加入set
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
            } else {
                // 移除i位置的元素
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}