package com.pandy.algorithm.leetcode.offer;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 * 根据栈先进后出的规则
 * 添加元素直接压入栈1
 * 删除元素 将栈1的元素先全部压入栈2 然后弹出栈2元素即可
 */
class CQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}