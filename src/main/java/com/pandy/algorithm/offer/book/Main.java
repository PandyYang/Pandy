package com.pandy.algorithm.offer.book;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Pandy
 * @Date 2021/11/6 13:42
 */
public class Main {

    public static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 数组中和为target的两个数字
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }

    /**
     * 数组中和为0的三个数字
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, result);
                int temp = nums[i];
                // 越过一样大小的数字
                while (i < nums.length && nums[i] == temp) {
                    ++i;
                }
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                while (nums[j] == temp && i < k) {
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }

    /**
     * 最长公共前缀
     */
    public String replaceString(String[] strs) {
        if (!checkStrs(strs)) return "";
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;
        }
        return res.toString();
    }
}
