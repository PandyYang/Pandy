package com.pandy.algorithm.base.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 二叉搜索树的后续遍历序列
 * <p>
 * 前面有道题是“栈的压入、弹出序列”。
 * 写这道题的例子时发现二叉树的中序序列和后序序列就满足栈的压入弹出序列关系。
 * 即如果把中序序列当做栈的压入序列，那么后序序列是该栈的一个弹出序列。
 * 而BST的中序是排序数组。因此将本题的序列排序作为中序序列，引用前面题的答案判断两序列是否满足上述关系即可。
 */
public class VerifySquenceOfBST {

    public boolean verify(int[] seq) {
        int[] arr = seq.clone();
        Arrays.sort(arr);
        return isPopOrder(arr, seq);
    }

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> s = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while (!s.empty() && s.peek() == popA[popIndex]) {
                s.pop();
                popIndex++;
            }
        }
        return s.empty();
    }
}
