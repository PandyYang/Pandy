package com.pandy.algorithm.huaweiod;

import java.util.Scanner;

public class ConvertToTitle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            while (n > 0) {
                n--;
                stringBuilder.append((char) (n % 26 + 'A'));
                n = n % 26;
            }
            System.out.println(stringBuilder.reverse());
        }
    }
}
