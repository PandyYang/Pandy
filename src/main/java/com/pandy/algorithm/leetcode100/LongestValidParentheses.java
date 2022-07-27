package com.pandy.algorithm.leetcode100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Pandy
 * @Date 2021/7/19 0:01
 * <p>
 * 最长的有效括号
 */
public class LongestValidParentheses {
    public static int longest(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longest(" )(()())"));
    }
}
