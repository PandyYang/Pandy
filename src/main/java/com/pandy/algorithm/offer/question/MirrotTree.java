package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.huawei.TreeNode;

// 求二叉树的镜像
public class MirrotTree {
    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        mirror(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        return root;
    }
}
