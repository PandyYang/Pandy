package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class PasswordValid {

    public static boolean hashDuplicatedString(String s) {
        for (int i = 0; i < s.length()-3; i++) {
            if (s.substring(i+3).contains(s.substring(i, i+3))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            if (s.length() <= 8 || hashDuplicatedString(s)) {
                System.out.println("NG");
                continue;
            }
            int count = 0;
            if (s.matches(".*[0-9].*")) count++;
            if (s.matches(".*[a-z].*")) count++;
            if (s.matches(".*[A-Z].*")) count++;
            if (s.matches(".*[^a-zA-Z-90-9].*")) count++;
            if (count < 3) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
        in.close();
    }
}
