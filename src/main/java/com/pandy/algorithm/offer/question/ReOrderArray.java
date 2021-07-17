package com.pandy.algorithm.offer.question;

public class ReOrderArray {
    // 遍历两次数组 第一次只增加奇数 第二次只增加偶数
    public int[] reOrderArray (int[] array) {
        // write code here
        int index = 0;
        int[] res= new int[array.length];
        for (int i : array) {
            if (i % 2 != 0) {
                res[index] = i;
                index++;
            }
        }

        for (int i : array) {
            if (i %2 == 0) {
                res[index] = i;
                index ++;
            }
        }
        return res;
    }
}
