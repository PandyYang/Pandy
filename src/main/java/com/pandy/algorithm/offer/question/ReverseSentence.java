package com.pandy.algorithm.offer.question;

/**
 * 反转句子 单词不反转
 */
public class ReverseSentence {

    public static String reverseSentence(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String reverse = reverse(s);
        String[] s1 = reverse.split(" ");
        for (String s2 : s1) {
            stringBuilder.append(reverse(s2));
            stringBuilder.append(" ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length() -1, "");
        return stringBuilder.toString();
    }

    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("123 456"));
    }
}
