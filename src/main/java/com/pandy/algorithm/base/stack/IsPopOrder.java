package com.pandy.algorithm.base.stack;

import java.util.Stack;

/**
 * 输入两个栈 判断栈的压入弹出序列
 * <p>
 * 假设有一串数字要将他们压栈: 1 2 3 4 5
 * <p>
 * 如果这个栈是很大很大，那么一次性全部压进去，再出栈：5 4 3 2 1
 * <p>
 * 但是，如果这个栈高度为4，会发生什么？ 1 2 3 4都顺利入栈，但是满了，那么要先出栈一个，才能入栈，那么就是先出4，然后压入5，随后再全部出栈：4 5 3 2 1
 * <p>
 * 那么我总结了所有可能的出栈情况:
 * <p>
 * 5 4 3 2 1//栈高度为5
 * <p>
 * 4 5 3 2 1//栈高度为4
 * <p>
 * 3 4 5 2 1//栈高度为3
 * <p>
 * 2 3 4 5 1//栈高度为2
 * <p>
 * 1 2 3 4 5//栈高度为1
 * <p>
 * 借助一个辅助的栈，遍历压栈的顺序，依次放进辅助栈中。
 * <p>
 * 对于每一个放进栈中的元素，栈顶元素都与出栈的popIndex对应位置的元素进行比较，是否相等，相等则popIndex++，再判断，直到为空或者不相等为止。
 */
public class IsPopOrder {
    public static boolean is(int[] pushA, int[] popA) {
        int len = pushA.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 0; i < len; i++) {
            s.push(pushA[i]);
            while (j < len && s.peek() == popA[j]) {
                s.pop();
                j = j + 1;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        System.out.println(is(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

}
