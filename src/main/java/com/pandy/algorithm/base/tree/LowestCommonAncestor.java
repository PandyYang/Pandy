package com.pandy.algorithm.base.tree;

import com.pandy.algorithm.offer.common.TreeNode;

/**
 * @Author Pandy
 * @Date 2021/7/31 18:26
 * 找出两个二叉树节点的最近公共祖先
 */
public class LowestCommonAncestor {

    public static int low(TreeNode root, int o1, int o2) {
        return commonAncestor(root, o1, o2).val;
    }

    public static TreeNode commonAncestor(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }

        TreeNode left = commonAncestor(root.left, o1, o2); // 返回左侧的p\q节点
        TreeNode right = commonAncestor(root.right, o1, o2); // 返回右侧的p\q节点

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree(new int[]{3, 5, 1, 6, 2, 0, 8, 0, 0, 7, 4}, 0);
        System.out.println(low(root, 5, 1));
    }
}
