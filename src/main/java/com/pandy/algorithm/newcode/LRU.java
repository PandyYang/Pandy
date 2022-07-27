package com.pandy.algorithm.newcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LRU {
    public int[] LRU(int[][] operators, int k) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            // 判断是1还是2
            int key = operator[1];
            switch (operator[0]) {
                // 为1插入
                case 1:
                    int value = operator[2];
                    if (map.size() < k) {
                        map.put(key, value);
                    } else {
                        Iterator<Integer> iterator = map.keySet().iterator();
                        map.remove(iterator.next());
                        map.put(key, value);
                    }
                    break;
                case 2:
                    if (map.containsKey(key)) {
                        int val = map.get(key);
                        list.add(val);
                        map.remove(key);
                        map.put(key, val);
                    } else {
                        list.add(-1);
                    }
                default:
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }
}
