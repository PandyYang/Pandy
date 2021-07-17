package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class CommonEndStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int cnt = 0;
            for(int i=0; i<=n; i++) {
                long end = i*i;
                if(String.valueOf(end).endsWith(String.valueOf(i))) {
                    cnt ++;
                }
            }
            System.out.println(cnt);
        }
    }
}
