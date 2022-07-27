package com.pandy.algorithm.offer.question;

/**
 * 字符串左移k位输出
 */
public class LeftRotateString {

    public static String leftK(String s, int k) {
        String s1 = reverse(s.substring(0, k));
        String s2 = reverse(s.substring(k));
        return reverse(s2) + reverse(s1);
    }

    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
