package com.pandy.algorithm.leetcode100;

/**
 * @Author Pandy
 * @Date 2021/7/18 23:32
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 找到一个靠右的小数
        int l = -1, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                l = i;
                r = i + 1;
            }
        }

        if (l == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int littleBigNumber = r;
            // 找到一个尽可能靠左的并且尽可能小的大数
            for (int i = nums.length - 1; i > l; i--) {
                if (nums[i] > nums[l]) {
                    littleBigNumber = i;
                    break;
                }
            }
            swap(nums, l, littleBigNumber);
            reverse(nums, r, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
