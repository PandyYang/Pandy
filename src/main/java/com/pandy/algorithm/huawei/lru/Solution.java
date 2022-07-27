package com.pandy.algorithm.huawei.lru;

import java.util.*;

public class Solution {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU(int[][] operators, int k) {
        // write code here
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int[] operator : operators) {
            int key = operator[1];
            switch (operator[0]) {
                case 1:
                    int value = operator[2];
                    if (map.size() < k) {
                        map.put(key, value);
                    } else {
                        Iterator res = map.keySet().iterator();
                        map.remove(res.next());
                        map.put(key, value);
                    }
                    break;
                case 2:
                    if (map.containsKey(key)) {
                        Integer val = map.get(key);
                        list.add(val);
                        map.remove(key);
                        map.put(key, val);
                    } else {
                        list.add(-1);
                    }
                    break;
                default:
            }
        }
        int[] result = new int[list.size()];
        int flag = 0;
        for (Integer s : list) {
            result[flag++] = s;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] res = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int[] res2 = LRU(res, 3);
        for (int i : res2) {
            System.out.println("i = " + i);
        }
    }
}
