package com.pandy.algorithm.geek.reverselist;

/**
 * @author Pandy
 */
public class ReverseList {
    // 迭代方式
    public static ListNode iterate(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 保存指针
            ListNode temp = curr.next; // temp = 2

            curr.next = prev; // 1 -> null   2 -> 1  3 -> 2  4 -> 3
            prev = curr; // 1 到 2

            curr = temp;// temp移动至
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(iterate(node1));
    }

    // 递归方式
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static class ListNode {
        private final int value;
        private ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
