package com.pandy.algorithm.offer.question;


import com.pandy.algorithm.offer.common.Node;

public class ReverseList {
    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Node newNode = reverse(node1);
        System.out.println(newNode);
    }

    // �ݹ�
    public static Node reverse(Node head) {
        if (head.getNext() == null) {
            return head;
        }

        Node reverseHead = reverse(head.getNext());
        reverseHead.getNext().setNext(head);
        head.setNext(null);
        System.out.println(reverseHead.getData());
        return reverseHead;
    }

    // ����
    public static Node reverse2(Node head) {
        Node pre = null;
        Node cur = head;
        Node temp;
        while (cur != null) {
            // ������һ���ڵ��ֹ����
            temp = cur.getNext();
            // cur�ڵ�ָ��ǰһ���ڵ� ��ת
            cur.setNext(pre);
            // ����
            pre = cur;
            // cur�ҵ��¸��ڵ�λ��
            cur = temp;
        }
        return pre;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
