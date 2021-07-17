package com.pandy.algorithm.huawei.jishi;

import java.util.*;

/**
 * 字符统计
 */
public class Ascci {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            char[] ch = str.toCharArray();
            // 字符和对应的此处写入treemap  排序按照ascii码 升序
            Map<Character, Integer> map = new TreeMap<Character, Integer>(
                    new Comparator<Character>() {
                        public int compare(Character c1, Character c2) {
                            return c1.compareTo(c2);
                        }
                    });
            for (char c : ch) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            // 放入list  按照
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1,
                                   Map.Entry<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            // key是不重复的
            for (Map.Entry<Character, Integer> mapping : list) {
                System.out.print(mapping.getKey());
            }
            System.out.println();
        }
    }
}
