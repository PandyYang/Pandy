package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.offer.common.TreeNode;

public class TreeDepth {
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return left < right ? right + 1 : left + 1;
    }
}
