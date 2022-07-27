package com.pandy.algorithm.newcode;


import java.util.LinkedList;
import java.util.List;

public class ConstructBinaryTree {
    private static List<Node> nodeList = null;
    private final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * 先序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        ConstructBinaryTree binTree = new ConstructBinaryTree();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }

    public void createBinTree() {
        nodeList = new LinkedList<Node>();
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new Node(array[i]));
        }

        for (int i = 0; i < array.length / 2 - 1; i++) {
            nodeList.get(i).leftChild = nodeList.get(i * 2 + 1);
            nodeList.get(i).rightChild = nodeList.get(i * 2 + 2);
        }

        int lastParentIndex = array.length / 2 - 1;

        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

}
