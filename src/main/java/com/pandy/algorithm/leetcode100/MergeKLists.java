package com.pandy.algorithm.leetcode100;

import com.pandy.algorithm.huawei.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Pandy
 * @Date 2021/7/18 20:57
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        //创建临时节点
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        // 构建小根堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        //将所有元素都加入优先队列
        for (ListNode list : lists) {
            if (list == null) continue;
            pq.add(list);
        }

        //
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll(); // 最小的一串
            curr.next = nextNode; // 弹出最小的节点 因为listnode是有序的
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next); //将next的下一个节点推向队列 其实是子串
            }
        }
        return dummyHead.next;
    }
}
