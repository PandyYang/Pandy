package com.pandy.algorithm.huawei.jishi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinNumStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int min = Integer.MAX_VALUE;
            String s = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            // 求出map中出现次数最少的值
            for (Integer v : map.values()) {
                min = v < min ? v : min;
            }

            // 去除出现次数最小的元素
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.get(c) != min) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
