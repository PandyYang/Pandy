package com.pandy.algorithm.leetcode;

import java.util.Arrays;

public class TwoSum {
    public static int[] sum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int res = target - arr[i];
            for (int j = i+1; j <arr.length; j++) {
                if (arr[j] == res) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sum(new int[]{3, 2, 4}, 6)));
    }
}
