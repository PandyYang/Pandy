package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

/**
 * @author Pandy
 */
public class LastWordLength {
    public static void Main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String[] s = in.nextLine().split(" ");
        System.out.println(s[s.length - 1].length());
    }
}
