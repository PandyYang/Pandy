package com.pandy.algorithm.geek.reverselist;

/**
 * @author Pandy
 * 求两数之和
 */
public class ArraySum {
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }
}
