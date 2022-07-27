package com.pandy.algorithm.offer.question;

public class FindKthToTail {
    public ListNode kth(ListNode pHead, int k) {
        // write code here
        if (pHead == null) return null;
        if (k == 0) return null;
        ListNode node1 = pHead;
        ListNode node2 = null;

        for (int i = 0; i < k - 1; i++) {
            if (node1.next == null) {
                return null;
            }
            node1 = node1.next;
        }
        node2 = pHead;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }
}
