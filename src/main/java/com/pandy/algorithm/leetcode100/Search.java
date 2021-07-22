package com.pandy.algorithm.leetcode100;

/**
 * @Author Pandy
 * @Date 2021/7/22 22:13
 *
 * [1,2,3,4,5,6,7]
 * k = 3
 * [4,5,6,7,1,2,3]
 *
 * 旋转数字的特性: 如果中间的数字 小于最右边的数字 那么右半部分是有序的
 * 如果中间的数字 大于最右边的数字 那么左半部分是有序的
 * 在有序的半段中用首尾两个数组判断目标值是否在这一区域中
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,5,1}, 3));
    }
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
                // 中间的值小于最右边的值
            } else if (nums[mid] < nums[right]) {
                // 右边是有序的  判断target在不在右边 如果在 则逐步缩小
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 中间的值大于最右边的值 那么左边是有序的 同样依次搜小范围
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
