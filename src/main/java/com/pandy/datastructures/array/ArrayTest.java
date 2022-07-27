package com.pandy.datastructures.array;

import java.util.Arrays;

/**
 * @Author Pandy
 * @Date 2021/7/21 20:27
 */
public class ArrayTest {

    /**
     * 改变矩阵维度
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if (m * n != r * c) {
            return nums;
        }

        int[][] reshapedNums = new int[r][c];
        int index = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapedNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapedNums;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(matrixReshape(res, 4, 1)));
    }

    /**
     * 将数组中的0移动到末尾
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }

        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    /**
     * 找出数组中最长的连续1
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur = num == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
