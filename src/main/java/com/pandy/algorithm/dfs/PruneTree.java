package com.pandy.algorithm.dfs;

import com.pandy.algorithm.offer.common.TreeNode;

/**
 * @Author Pandy
 * @Date 2021/8/7 9:08
 * 将所有路径上全是0的路径去掉
 */
public class PruneTree {
    public TreeNode tree(TreeNode root) {
        if (root == null) return null;
        // 当前节点可能不是叶子节点 但如果叶子节点都删除完了
        // 当前节点就成为了叶子节点
        root.left = tree(root.left);
        root.right = tree(root.right);

        // 如果叶子节点是0 就删除 返回一个空的节点
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        // 否则不要删除 直接返回即可
        return root;
    }
}
