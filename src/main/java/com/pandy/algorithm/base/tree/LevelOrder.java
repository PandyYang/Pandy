package com.pandy.algorithm.base.tree;

import com.pandy.algorithm.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Pandy
 * @Date 2021/7/31 14:54
 */
public class LevelOrder {
    public static ArrayList<ArrayList<Integer>> levelOrder1(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<Integer>();

            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {

                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);

                level.add(queue.poll().data);
            }
            res.add(level);
        }
        return res;
    }
}
