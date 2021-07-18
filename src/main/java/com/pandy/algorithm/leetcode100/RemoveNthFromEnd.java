package com.pandy.algorithm.leetcode100;

import com.pandy.algorithm.huawei.ListNode;

/**
 * @Author Pandy
 * @Date 2021/7/18 16:13
 * 移除链表的倒数第k个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 最后一个节点
        if (head.next == null || n == 1) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先走n步
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode prev = null;
        // 找到第n个节点
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
