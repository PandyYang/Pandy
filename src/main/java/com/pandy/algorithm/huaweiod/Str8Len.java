package com.pandy.algorithm.huaweiod;

import java.util.Scanner;

public class Str8Len {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            for (int i1 = 0; i1 < i; i1++) {
                String next = scanner.next();
                // �ȴ���Ϊ8��������
                while (next.length() % 8 != 0) {
                    next = next + '0';
                }
                for (int j = 0; j < next.length(); j+= 8) {
                    System.out.println(next.substring(j, j + 8));
                }
            }
        }
    }
}
