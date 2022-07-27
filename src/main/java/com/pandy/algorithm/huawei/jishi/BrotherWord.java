package com.pandy.algorithm.huawei.jishi;

import java.util.*;

public class BrotherWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            List<String> list = new LinkedList<>();
            List<String> mubiaoList = new LinkedList<>();
            // 目标
            String mubiao = s1[s1.length - 2];
            // 位置
            int weizhi = Integer.parseInt(s1[s1.length - 1]);
            for (int i = 1; i <= Integer.parseInt(s1[0]); i++) {
                list.add(s1[i]);
            }
            // 找到兄弟单词
            for (String s2 : list) {
                if (s2.equals(mubiao)) {
                    continue;
                }
                if (is(mubiao, s2)) {
                    mubiaoList.add(s2);
                }
            }
            System.out.println(mubiaoList.size());
            // 字符排序
            mubiaoList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            // 确保存在数字k
            if (mubiaoList.size() > weizhi) {
                System.out.println(mubiaoList.get(weizhi - 1));
            }
        }
    }

    public static boolean is(String s1, String s2) {
        Map<Character, Integer> map = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }

        return map.equals(map2);
    }
}
