package com.pandy.algorithm.base.search;

/**
 * @Author Pandy
 * @Date 2021/7/31 14:36
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) /2;
            if (target == nums[mid]) {
                while (mid != 0 && (nums[mid-1] == nums[mid]))
                    mid--;
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int search2 (int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = low+ (high- low) / 2;
            if(nums[mid] == target){
                // 如果有相同的结果出现 只找出靠近最左边的
                while(mid != 0 &&(nums[mid-1] == nums[mid])){
                    mid--;
                }
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(search2(new int[]{1, 1, 1, 1, 1}, 1));
    }
}
