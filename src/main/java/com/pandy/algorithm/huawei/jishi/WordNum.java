package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

/**
 * @author Pandy
 */
public class WordNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String word = in.nextLine();
        final String s = str.toLowerCase();
        final String s1 = word.toLowerCase();
        final char[] chars = s.toCharArray();
        int flag = 0;
        for (char aChar : chars) {
            if (s1.equals(String.valueOf(aChar))) {
                flag++;
            }
        }
        System.out.println(flag);
    }
}
