package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树第k大的节点
 */
public class Kth {

    public TreeNode kth(TreeNode root, int k) {
        return treeNodes.get(k-1);
    }

    List<TreeNode> treeNodes = new LinkedList<>();
    public void inorder(TreeNode node) {
        if (node != null) {
          inorder(node.left);
          treeNodes.add(node);
          inorder(node.right);
        }
    }
}
