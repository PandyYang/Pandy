package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class BigLetterNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] ch = sc.nextLine().toCharArray();
            int nums = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] >= 'A' && ch[i] <= 'Z') {
                    nums++;
                }
            }
            System.out.println(nums);
        }
    }
}
