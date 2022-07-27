package com.pandy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

// 滑动窗口while i j ans n等参数都需要
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int j = 0;
//        for (int i = nums1.length-m; i <= m+n && nums2.length > j; i++) {
//            nums1[i] = nums2[j];
//            j++;
//        }
//        Arrays.sort(nums1);
//        for (int i : nums1) {
//            System.out.println("i = " + i);
//        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p2 >= 0) {
            nums1[tail--] = (p1 >= 0 && nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
//        merge(new int[]{0}, 0, new int[]{1}, 1);
        merge2(new int[]{0}, 0, new int[]{1}, 1);
    }

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
