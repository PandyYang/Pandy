package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.offer.common.TreeNode;

public class ConvertTreeToList {
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode convert(TreeNode pRootOfTree) {
        convertSub(pRootOfTree);
        return realHead;
    }

    private void convertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;

        convertSub(pRootOfTree.left);

        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }

        convertSub(pRootOfTree.right);
    }
}
