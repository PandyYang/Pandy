package com.pandy.algorithm.dfs;

public class CanPartition {

    public boolean isPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) return false;

        return dfs(nums, sum >> 1, 0);
    }

    private boolean dfs(int[] nums, int target, int index) {

        // target等于0 说明存在一些元素和等于sum / 2  直接返回true
        if (target == 0) return true;

        // 数组选招完毕 target小于0
        if (index == nums.length || target < 0) return false;

        // 选择当前元素和不选择当前元素两种情况
        return dfs(nums, target - nums[index], index+1) ||
                dfs(nums, target, index + 1);
    }
}
