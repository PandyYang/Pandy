package com.pandy.algorithm.huawei.jishi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class strMove {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Map<Character, Integer> map = new HashMap<>();
//        while (scanner.hasNext()) {
//            String s = scanner.nextLine();
//            int x = 0, y = 0;
//            String[] sArray = s.split(",");
//            String res = "[ADWS]\\d{1}\\d?";
//            for (int i = 0; i < sArray.length; i++) {
//                if (sArray[i].matches(res)) {
//                    map.put(sArray[i].charAt(0), map.getOrDefault(sArray[i].charAt(0), 0) + Integer.valueOf(sArray[i].substring(1)));
//                }
//                x = x-map.get('A') + map.get('D');
//                y = y-map.get('S') + map.get('W');
//                System.out.println(x + " " + y);
//                map.clear();
//            }
//            scanner.close();
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int x = 0, y = 0;
            String[] sArray = s.split(";");
            String res = "[ADWS]\\d{1}\\d?";
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i].matches(res))
                    map.put(sArray[i].charAt(0), map.getOrDefault(sArray[i].charAt(0), 0) + Integer.valueOf(sArray[i].substring(1)));
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x + "," + y);
            map.clear();
        }
        scanner.close();
    }
}
