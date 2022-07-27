package com.pandy.algorithm.leetcode;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.length() == 0;
    }
}
