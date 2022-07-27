package com.pandy.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubString(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int test(String s) {
        int ans = 0, i = 0, j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
