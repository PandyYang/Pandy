package com.pandy.algorithm.offer.question;


import com.pandy.algorithm.offer.common.TreeNode;

/**
 * 求二叉树的镜像
 */
public class MirrorTreeNode {

    /**
     * ##采用递归思想##
     * 1.先处理根节点。若根节点为空，或为单个节点，则直接返回。否则交换左右节点
     * 2.处理根节点的左子树
     * 3.处理根节点的右子树
     *
     * @param root
     * @return
     */
    private TreeNode mirror(TreeNode root) {
        if (root == null) return null;

        if (root.right == null && root.left == null) {
            return null;
        }

        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归root的左右
        mirror(root.left);
        mirror(root.right);
        return root;
    }
}
