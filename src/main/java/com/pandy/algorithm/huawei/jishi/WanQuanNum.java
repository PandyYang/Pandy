package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class WanQuanNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int count = 0;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
