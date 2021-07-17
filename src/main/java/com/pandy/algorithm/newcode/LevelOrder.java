package com.pandy.algorithm.newcode;


import com.pandy.algorithm.huawei.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 返回二叉树的层次遍历
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                level.add(queue.poll().val);
            }
            res.add(level);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return res;
        count(root, 0);
        return res;
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public void count(TreeNode node, int level) {
        if (level == res.size()) res.add(new ArrayList<Integer>());

        ArrayList<Integer> list = res.get(level);
        list.add(node.val);

        if (node.left != null) {
            count(node.left, level + 1);
        }

        if (node.right != null) {
            count(node.right, level + 1);
        }
    }
}
