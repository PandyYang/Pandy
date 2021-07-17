package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class EmptyBottom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (i == 0) {
                break;
            }
            System.out.println(i / 2);
        }
    }
}
