package com.pandy.algorithm.leetcode100;

/**
 * @author Pandy
 */
public class Int2Roman {
    public static String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                stringBuilder.append(rom[i]);
                num-=values[i];
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}
