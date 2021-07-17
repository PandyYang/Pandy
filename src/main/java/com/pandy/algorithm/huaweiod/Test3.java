package com.pandy.algorithm.huaweiod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            int i1 = in.nextInt();
            res.add(i1);
            int i2 = in.nextInt();
            res.add(i2);
            list.add(res);
        }
        int delete = in.nextInt();
        int delete_index = 0;

        list.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });


        // 找出对应的层级
        for (int i = 0; i < length - 1; i++) {
            if (list.get(i).get(0) == delete) {
                delete_index = i;
            }
        }

        for (int i = 0; i < delete_index; i++) {
            if (list.get(i).get(1) == 0) {
                continue;
            }
            System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
        }
    }
}
