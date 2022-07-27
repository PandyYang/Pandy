package com.pandy.algorithm.offer.question;

import java.util.Stack;

/**
 * 栈的弹出压入序列
 * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
 * <p>
 * <p>
 * 此时栈顶2≠4，继续入栈3
 * <p>
 * <p>
 * 此时栈顶3≠4，继续入栈4
 * <p>
 * <p>
 * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
 * <p>
 * <p>
 * 此时栈顶3≠5，继续入栈5
 * <p>
 * <p>
 * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }

        Stack<Integer> s = new Stack<>();
        // 用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            // 如果栈不为空，且栈顶元素等于弹出序列。
            while (!s.empty() && s.peek() == popA[popIndex]) {
                // 出栈
                s.pop();
                // 弹出序列向后一位。
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
