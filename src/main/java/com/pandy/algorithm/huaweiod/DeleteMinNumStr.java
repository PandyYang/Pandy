package com.pandy.algorithm.huaweiod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class DeleteMinNumStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
            for (int i = 0; i < next.length(); i++) {
                if (map.containsKey(next.charAt(i))) {
                    map.put(next.charAt(i), map.get(next.charAt(i)) + 1);
                } else {
                    map.put(next.charAt(i), 1);
                }
            }

            Integer character1 = map.values().stream().sorted().findFirst().get();
            for (Character character : map.keySet()) {
                if (map.get(character).equals(character1)) {
                    map.remove(character);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Character, Integer> integerEntry : map.entrySet()) {
                for (Integer i = 0; i < integerEntry.getValue(); i++) {
                    stringBuilder.append(integerEntry.getKey());
                }
            }
            System.out.println(stringBuilder);
        }
    }

}