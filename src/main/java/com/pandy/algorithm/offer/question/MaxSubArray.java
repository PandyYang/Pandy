package com.pandy.algorithm.offer.question;

public class MaxSubArray {
    public int find(int[] arr) {
        if (arr.length == 0 || arr == null) return 0;
        int sum = 0;
        int greatSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (sum <= 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > greatSum) {
                greatSum = sum;
            }
        }
        return greatSum;
    }
}
