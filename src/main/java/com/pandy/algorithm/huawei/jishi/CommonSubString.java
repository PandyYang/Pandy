package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class CommonSubString {
    public static void main(String[] args) {
        // 求公共子串
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String max = s1.length() >= s2.length() ? s1 : s2;
            String min = s1.length() >= s2.length() ? s2 : s1;
            int l = 0;
            String s = "";
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j <= min.length(); j++) {
                    //  j - i > L就相当于L记录了当前最长的子串
                    // 如果后面的子串长度小于L的话是不会进到if里面去的
                    if (max.contains(min.substring(i, j)) && j - i > l) {
                        l = j - i;
                        s = min.substring(i, j);
                    }
                }
            }
            System.out.println(s.length());
        }
        sc.close();
    }
}
