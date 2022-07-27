package com.pandy.algorithm.main;

public class Replace {
    public static int[] replace(char[] arr) {
        int num = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                num++;
            }
        }
        len = num * 2 + arr.length;
        int[] res = new int[len];

        while (len >= 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ' ') {
                    res[len--] = arr[i];
                } else {
                    res[len--] = '0';
                    res[len--] = '2';
                    res[len--] = '%';
                }
            }
        }
        return res;
    }
}
