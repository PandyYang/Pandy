package com.pandy.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法求解元素的全排类问题
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.premute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> premute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(res, list, nums);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums) {

        // 回溯法递归终止条件 找到全排列
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backTrack(res, list, nums); // 进入下一层
                list.remove(list.size() - 1); // 往上退一层
            }
        }
    }
}
