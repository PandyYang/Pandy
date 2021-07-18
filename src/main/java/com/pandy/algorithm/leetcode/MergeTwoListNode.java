package com.pandy.algorithm.leetcode;

import com.pandy.algorithm.huawei.ListNode;

/**
 * @Author Pandy
 * @Date 2021/7/18 15:33
 * 合并两个升序的链表
 */
public class MergeTwoListNode {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
