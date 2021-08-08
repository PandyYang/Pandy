package com.pandy.algorithm.base.tree;

import com.pandy.algorithm.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 从上往下打印二叉树
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> print(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return result;
    }

    // 二叉树的广度优先遍历

    public ArrayList<Integer> print2(TreeNode root) {
        // queue用开保存当前遍历到了哪个节点 一次性把一个节点的点左右子都入队
        Queue<TreeNode> queue = new LinkedList<>();
        // list用来保存输出的节点
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        TreeNode current = root;

        queue.offer(current);

        // 只要队列中没有节点 就说明还没遍历完 继续
        // 每次从队列出队 然后将这个节点的左右入队 广度优先遍历
        while (!queue.isEmpty()) {

            //出队操作
            current = queue.poll();
            list.add(current.val);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return list;
    }
}
