package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.huawei.TreeNode;

/**
 * 判断是否为树的子结构
 */
public class HasSubTree {

    // 遍历大数
    public boolean hashSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        // 如果找到与子树同根的值  走判断方法
        if (root1.val == root2.val) {
            if (judge(root1, root2)) {
                return true;
            }
        }

        // 遍历左孩子右孩子
        return hashSubTree(root1.left, root2) || hashSubTree(root1.right, root2);
    }

    // 判断是否是子结构
    public boolean judge(TreeNode root, TreeNode subTree) {

        // 子结构已经循环完毕 代表全部匹配
        if (subTree == null) return true;

        // 大树已经循环完毕 并未成功匹配
        if (root == null) return false;

        // 相等之后判断左右孩子
        if (root.val == subTree.val) {
            return judge(root.left, subTree.left) && judge(
                    root.right, subTree.left
            );
        }
        return false;
    }
}
