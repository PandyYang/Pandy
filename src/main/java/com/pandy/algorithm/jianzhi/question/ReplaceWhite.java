package com.pandy.algorithm.jianzhi.question;

public class ReplaceWhite {
    public static void main(String[] args) {
        String str = "we are happy";
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
    }
}
