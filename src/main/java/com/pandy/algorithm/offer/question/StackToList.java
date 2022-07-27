package com.pandy.algorithm.offer.question;

import java.util.Stack;

public class StackToList {
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
