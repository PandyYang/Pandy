package com.pandy.util.randomCode;

import java.util.Random;

/**
 * @author Pandy
 * @date 16/2/2022
 */
public class NumAndChar {
    public static void main(String[] args) {
        System.out.println(getCode());
    }

    public static String getCode() {
        // 创建一个由大写和小写字母和数字组成的字符串
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        //合并所有字符串
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        //创建随机字符串生成器
        StringBuilder sb = new StringBuilder();

        //创建一个Random类的对象
        Random random = new Random();

        //指定随机字符串的长度
        int length = 6;

        for(int i = 0; i < length; i++) {

            //生成随机索引号
            int index = random.nextInt(alphaNumeric.length());

            // 从字符串中获取由索引 index 指定的字符
            char randomChar = alphaNumeric.charAt(index);

            // 将字符追加到字符串生成器
            sb.append(randomChar);
        }

        return sb.toString();
    }
}

