package com.pandy.algorithm.offer.question;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 求数组中的元素 组成的最小的数字
 * 比较每个数最左边第一位数字大小，小的放在前面。这里发现用字符串排序即可
 */
public class MinNum {
    public static String min(int[] arr) {
        int len = arr.length;
        String[] str = new String[len];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });

        for (int i = 0; i < len; i++) {
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(min(new int[]{3, 30, 34, 5, 9}));
    }
}
