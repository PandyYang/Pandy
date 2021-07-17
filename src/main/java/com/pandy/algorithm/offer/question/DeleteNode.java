package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.offer.common.Node;

public class DeleteNode {
    public void delete(ListNode head, ListNode deNode) {
        if (deNode == null || head == null)
            return;
        if (head == deNode) {
            head = null;
        } else {
            if (deNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                deNode.val = deNode.next.val;
                deNode.next = deNode.next.next;
            }
        }
    }

    private static void delete(Node head, Node dnode) {
        // 遍历删除尾节点
        if (dnode.getNext() == null) {
            while (head.getNext() != dnode) {
                head = head.getNext();
            }
            head.setNext(null);
        // 头节点
        } else if (head == dnode) {
            head = null;
        } else {
            // 直接连接至下下一个节点
            dnode.setData(dnode.getNext().getData());
            dnode.setNext(dnode.getNext().getNext());
        }
    }
}
