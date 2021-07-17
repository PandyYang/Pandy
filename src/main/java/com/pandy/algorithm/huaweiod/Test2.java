package com.pandy.algorithm.huaweiod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line0 = in.nextLine().split(" ");
        int r = Integer.parseInt(line0[2]);
        List<Integer> list1 = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        for (Integer a : list1) {
            for (Integer b : list2) {
                if (a <=b && b-a <= r) {
                    list.add(a + " " + b);
//                    System.out.println(a + " " + b);
                    break;
                }
            }
        }

        Arrays.sort(list.toArray());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
