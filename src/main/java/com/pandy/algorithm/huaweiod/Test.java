package com.pandy.algorithm.huaweiod;

import java.util.Scanner;

public class Test {

    public static int test(String next) {
        for (char c : next.toCharArray()) {
            if (!Character.isLetter(c)) {
                return 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next.length(); i++) {
            // 每次比较sb的最后一个元素和新加入的元素 如果相等则直接删除sb最后一个元素 往后遍历整个next
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == next.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(next.charAt(i));
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            System.out.println(test(next));
        }
    }
}
