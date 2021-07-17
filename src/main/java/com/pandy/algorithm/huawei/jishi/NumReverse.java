package com.pandy.algorithm.huawei.jishi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Pandy
 */
public class NumReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque words = new LinkedList();
        final String[] split = in.nextLine().split("\\s+");
        for (String s : split) {
            words.addFirst(s);
        }
        System.out.println(String.join(" ", words));
    }
}
