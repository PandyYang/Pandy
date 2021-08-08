package com.pandy.algorithm.bfs;


/**
 * 不需要确定遍历到了哪一层
 *
 * while queue 不空：
 *     cur = queue.pop()
 *     for 节点 in cur的所有相邻节点：
 *         if 该节点有效且未访问过：
 *             queue.push(该节点)
 *
 * 需要确定遍历到了哪一层
 *
 * level = 0
 * while queue 不空：
 *     size = queue.size()
 *     while (size --) {
 *         cur = queue.pop()
 *         for 节点 in cur的所有相邻节点：
 *             if 该节点有效且未被访问过：
 *                 queue.push(该节点)
 *     }
 *     level ++;
 *
  */

import com.pandy.algorithm.huawei.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.peek();
                q.poll();
                if (cur == null) {
                    continue;
                }
                level.add(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            if (!level.isEmpty()) {
                res.add(level);
            }
        }
        return res;
    }
}