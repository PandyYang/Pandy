package com.pandy.algorithm.offer.question;

public class FindFirstCommonNode {
    public ListNode find(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : l2;
            p2 = p2 != null ? p2.next : l1;
        }
        return p1;
    }

    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != p2) {
            p1 = p1 == null ? l2 : p1.next;
            p2 = p2 == null ? l1 : p2.next;
        }
        return p1;
    }
}
