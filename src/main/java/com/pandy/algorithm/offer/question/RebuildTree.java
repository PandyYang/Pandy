package com.pandy.algorithm.offer.question;


import com.pandy.algorithm.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RebuildTree {
    public static ArrayList<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println(list);
        return list;
    }

    public static ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        System.out.println(list);
        return list;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }


        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i < endIn; i++) {
            if (in[i] == pre[startPre]) {

                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        // 找出root节点 前序遍历的第一个节点为root节点
        TreeNode root = new TreeNode(pre[0]);
        // 在中序遍历中找到前序遍历的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树为
                root.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public TreeNode reConstructBinaryTree3(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        // 找到根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // Arrays.copyOf()是左闭右开
                root.left = reConstructBinaryTree3(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree3(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
