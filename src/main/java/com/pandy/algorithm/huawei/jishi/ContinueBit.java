package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class ContinueBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s = Integer.toBinaryString(n);
            int max = 0;
            String[] str = s.split("0");
            for (int i = 0; i < str.length; i++) {
                if (str[i].length() > max) {
                    max = str[i].length();
                    continue;
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
