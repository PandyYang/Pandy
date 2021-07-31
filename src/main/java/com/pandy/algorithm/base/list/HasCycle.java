package com.pandy.algorithm.base.list;

import com.pandy.algorithm.huawei.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Pandy
 * @Date 2021/7/31 14:29
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
