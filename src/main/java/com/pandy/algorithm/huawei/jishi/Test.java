package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(s);
            while (stringBuilder.length() % 8 != 0) {
                stringBuilder.append('0');
            }

            String s1 = stringBuilder.toString();
            while (s1.length() > 0) {
                System.out.println(s1.substring(0, 8));
                s1 = s1.substring(8);
            }
        }
    }



    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String s = in.nextLine();
//            String s1 = in.nextLine();
//            int count = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (s1.toLowerCase().equals(String.valueOf(s.charAt(i)).toLowerCase())) {
//                    count++;
//                }
//            }
//            System.out.println(count);
//        }
//    }
}
