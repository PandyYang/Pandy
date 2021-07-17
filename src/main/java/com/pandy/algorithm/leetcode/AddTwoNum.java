package com.pandy.algorithm.leetcode;


import com.pandy.algorithm.huawei.ListNode;

/**
 * 两数相加
 */
public class AddTwoNum {
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root; //虚拟节点
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sumVal = l1val + l2val + carry;
            carry = sumVal / 10; // 进位
            ListNode sumNode = new ListNode(sumVal % 10); // 余数
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
}
