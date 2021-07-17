package com.pandy.algorithm.huaweiod;

import java.util.Scanner;

public class StringUnZip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int n = 1;
            char first = s.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                if (first == s.charAt(i)) {
                    n++;
                } else {
                    if (n > 1) {
                        stringBuilder.append(first);
                        stringBuilder.append(n);
                        n = 1;
                    } else {
                        stringBuilder.append(first);
                    }
                }
                first = s.charAt(i);
            }

            stringBuilder.append(first);
            if (n > 1) {
                stringBuilder.append(n);
            }
            System.out.println(stringBuilder);
        }
    }
}
