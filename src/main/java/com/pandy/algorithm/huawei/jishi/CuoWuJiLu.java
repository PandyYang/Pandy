package com.pandy.algorithm.huawei.jishi;

import java.util.*;

public class CuoWuJiLu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (in.hasNext()) {
            String s = in.next();
            int lineNum = in.nextInt();
            String[] split = s.split("\\\\");
            String s1 = split[split.length - 1];

            // 记录最后的16个字符
            if(s1.length() > 16) {
                s1 = s1.substring(s1.length() - 16);
            }
            String key = s1 + " " + lineNum;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        // 记录最后八条记录
        int count = 0;
        for (String s2 : map.keySet()) {
            count++;
            if (count > (map.keySet().size() - 8)) {
                System.out.println(s2 + " " + map.get(s2));
            }
        }
    }
}
