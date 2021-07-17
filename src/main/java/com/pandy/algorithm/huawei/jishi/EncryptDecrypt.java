package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

/**
 * 加密和解密
 */
public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNext()) {
            String s = in.nextLine();
            i++;
            // 奇数次数输入为加密 偶数次数输入为解密 解密总在加密之后
            if (i % 2 == 0) {
                decrypt(s);
            } else {
                encrypt(s);
            }
        }
    }

    // 加密
    public static void encrypt(String res) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : res.toCharArray()) {
            // 为字母
            if(Character.isLetter(c)) {
                // 如果字母为大写
                if (c >= 65 && c <= 90) {
                    if (c == 'Z') {
                        stringBuilder.append("a");
                    } else {
                        stringBuilder.append((String.valueOf((char)(c + 1)).toLowerCase()));
                    }
                // 如果字母为小写
                } else if (c >= 97 && c <= 122){
                    if (c == 'z') {
                        stringBuilder.append("A");
                    } else {
                        stringBuilder.append((String.valueOf((char)(c + 1)).toUpperCase()));
                    }
                }

                // 为数字
            } else if (Character.isDigit(c)) {
                if (c == '9') {
                    stringBuilder.append("0");
                } else {
                    stringBuilder.append(Integer.parseInt(String.valueOf(c)) + 1);
                }
            }
        }
        System.out.println(stringBuilder);
    }

    // 解密
    public static void decrypt(String res) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : res.toCharArray()) {
            // 如果字母为小写
            if (c >= 97 && c <= 122) {
                if (c == 'a') {
                    stringBuilder.append("Z");
                } else {
                    stringBuilder.append((String.valueOf((char)(c - 1)).toUpperCase()));
                }
                // 如果字母为大写
            } else if (c >= 65 && c <= 90){
                if (c == 'A') {
                    stringBuilder.append("z");
                } else {
                    stringBuilder.append((String.valueOf((char)(c - 1)).toLowerCase()));
                }
            }
            if (Character.isDigit(c)) {
                if (c == '0') {
                    stringBuilder.append("9");
                } else {
                    stringBuilder.append(Integer.parseInt(String.valueOf(c)) - 1);
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
