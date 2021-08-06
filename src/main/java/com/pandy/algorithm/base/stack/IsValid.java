package com.pandy.algorithm.base.stack;

import java.util.Stack;

public class IsValid {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == '{')
                stack.push(c);
            else if (c == '[')
                stack.push(c);
            //未完成之前栈不能为空 并且弹出的元素要和c相等 否则直接为false
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        // 最后判断不多不少
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }
}
