package com.pandy.algorithm.offer.question;

import java.util.PriorityQueue;

/**
 * 第k大的元素和第k小的元素
 */
public class KmaxKmin {
    public static int kmax(int[] arr, int k) {
        if (arr.length < 1) return -1;
        // 求第k大的元素 使用小根堆
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i : arr) {
            if (min.size() < k) {
                min.add(i);
            } else {
                if (min.size() > 0 && i < min.peek()) {
                    min.remove();
                    min.add(i);
                }
            }
        }
        return min.peek();
    }

    // 求第k小的元素 使用大根堆
    public static int kmin(int[] arr, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> (y - x));
        for (int i : arr) {
            if (max.size() < k) {
                max.add(k);
            } else {
                if (max.peek() < i) {
                    max.remove();
                    max.add(i);
                }
            }
        }
        return max.peek();
    }
}
