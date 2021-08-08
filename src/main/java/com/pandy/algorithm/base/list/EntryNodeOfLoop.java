package com.pandy.algorithm.base.list;

import com.pandy.algorithm.huawei.ListNode;

public class EntryNodeOfLoop {
    public ListNode test(ListNode listNode) {
        if (listNode == null || listNode.next == null) return null;
        ListNode l1 = listNode;
        ListNode l2 = listNode;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                l2 = listNode;
                while (l1 != l2) {
                    l1 = l1.next;
                    l2 = l2.next;
                }
                return l1;
            }
        }
        return null;
    }
}
