package com.pandy.algorithm.sort;

import java.util.HashMap;

/**
 * @author Pandy
 * 求两数之和
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap map =new HashMap();
        int[] res = new int[2];
        for (int i = 0; i< nums.length; i++) {
            int res1 = target - nums[i];
            if (map.containsKey(res1)) {
                res[0] = (int) map.get(res1);
                res[1] = i;
                return res;
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] res = {22, 14, 6, 7, 1, 3};
        final int[] ints = twoSum(res, 7);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
