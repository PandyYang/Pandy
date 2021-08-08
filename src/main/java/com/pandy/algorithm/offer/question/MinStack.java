package com.pandy.algorithm.offer.question;

import java.util.Stack;

/**
 * 使用双栈实现包含min函数的栈
 */
public class MinStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        // 将数据压入数据栈
        dataStack.push(node);

        // 判断当前最小栈的元素 为空 或者小于当前压入的元素
        // 直接压入最小栈
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {

            // 否则
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
    }
}
