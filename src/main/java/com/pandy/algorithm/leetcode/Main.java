package com.pandy.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Pandy
 * @Date 2021/11/7 12:21
 */
public class Main {

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     */
    public static int longestValidParentheses(String s) {
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
        System.out.println(longestValidParentheses(")()())"));
    }
}
