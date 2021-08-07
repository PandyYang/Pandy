package com.pandy.test;

import java.util.*;

public class TestSort {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 5);
        map.put("3", 3);
        map.put("2", 4);
        map.put("5", 1);
        map.put("4", 2);
//        Arrays.asList(map.entrySet()).sort((a, b) -> map.get(a) - map.get(b));

        System.out.println(Collections.singletonList(map.values()));
    }
}
