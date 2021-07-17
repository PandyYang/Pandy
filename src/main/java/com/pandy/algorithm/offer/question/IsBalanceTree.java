package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.offer.common.TreeNode;

/**
 * 判断是否是平衡二叉树
 * 平衡二叉树的定义是左右的深度小于1
 */
public class IsBalanceTree {
    public boolean isBalance(TreeNode root) {
        if (root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int diff = left - right;
        if (diff <= 1 && diff >= -1) {
            return true;
        }
        return false;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        depth = Math.max(left, right);
        return depth + 1;
    }
}
