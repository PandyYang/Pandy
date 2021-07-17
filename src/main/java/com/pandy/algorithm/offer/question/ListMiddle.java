package com.pandy.algorithm.offer.question;

import com.pandy.algorithm.offer.common.Node;

/**
 * 求链表的中间节点
 */
public class ListMiddle {
    public static Node getMid(Node a) {
        if (a == null) return null;
        Node slow = a;
        Node fast = a;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
