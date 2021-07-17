package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class Choose7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (String.valueOf(i).contains("7")) {
                    count++;
                    continue;
                } else {
                    if (i!= 0 && i % 7 == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
