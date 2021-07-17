package com.pandy.algorithm.huawei.jishi;

import java.util.*;

public class PicSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = s.toCharArray();
            List<String> list = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                list.add(String.valueOf(s.charAt(i)));
            }

            Arrays.sort(chars);

            System.out.println(chars);
        }
    }
}
