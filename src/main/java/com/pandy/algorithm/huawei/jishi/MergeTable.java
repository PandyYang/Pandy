package com.pandy.algorithm.huawei.jishi;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Pandy
 */
//public class MergeTable {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Map map = new HashMap();
//        while (in.hasNext()) {
//            int a = in.nextInt();
//            for (int i = 0; i < a; i++) {
//                Scanner in2 = new Scanner(System.in);
//                String res = in2.nextLine();
//                final char[] chars = res.toCharArray();
//
//                if (map.containsKey(chars[0])) {
//                    final String o = map.get(chars[0]).toString();
//                    map.put(chars[0],  Integer.valueOf(o) + (chars[2] - '0'));
//                } else {
//                    map.put(chars[0], chars[2]);
//                }
//            }
//            for (Object o : map.keySet()) {
//                System.out.println(o +" " + map.get(o));
//            }
//        }
//    }
//}

/**
 * 合并表格记录并按照key升序排序
 */
public class MergeTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int next = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                System.out.println(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue());
            }
        }
    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Map<Object, Object> map = new HashMap();
//        while (in.hasNext()) {
//            int a = in.nextInt();
//            final String s = in.nextLine();
//            for (int i = 0; i < a; i++) {
//                String res = in.nextLine();
//                if (res.length() == 1) {
//                    res = res + " " + 0;
//                }
//                final char[] chars = res.toCharArray();
//                if (map.containsKey(chars[0])) {
//                    final String o = map.get(chars[0]).toString();
//                    map.put(chars[0],  Integer.valueOf(o) + (chars[2] - '0'));
//                } else {
//                    map.put(chars[0], chars[2]);
//                }
//            }
//            for (Object o : map.keySet()) {
//                System.out.println(o +" " + map.get(o));
//            }
//        }
//    }
}
