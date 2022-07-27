package com.pandy.algorithm.huawei.jishi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pandy
 */
public class Num8Word {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new LinkedList();
        while (in.hasNext()) {
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int zero = 8 - str.length() % 8;
            while ((zero > 0) && (zero < 8)) {
                sb.append("0");
                zero--;
            }
            String str1 = sb.toString();
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }
        }
    }
}
