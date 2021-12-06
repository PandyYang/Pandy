package com.pandy.algorithm.main;

import com.pandy.algorithm.offer.question.ListNode;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String replace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode heada = headA, headb = headB;
        while (heada != headb) {
            heada = heada == null ? headA : heada.next;
            headb = headb == null ? headB : headb.next;
        }
        return heada;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode headFirst = head, headSecond = head;
        while (true) {
            if (headFirst == null || headFirst.next == null) return false;
            headFirst = headFirst.next.next;
            headSecond = headSecond.next;
            if (headFirst == headSecond) {
                return true;
            }
        }
    }
}
