package com.pandy.algorithm.offer.question;


import com.pandy.algorithm.huawei.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> print(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return list;
    }
}
