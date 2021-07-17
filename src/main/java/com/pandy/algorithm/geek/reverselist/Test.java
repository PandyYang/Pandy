package com.pandy.algorithm.geek.reverselist;

import java.util.Arrays;

/**
 * @author Pandy
 */
public class Test {

    // 统计素数的个数
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    // 暴力法
    public static boolean isPrime(int x) {
        for (int i = 2; i< x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //
    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n]; // false代表素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count ++;
                for (int j = i*i;  j< n; j+=i) { // j是合数的标记为
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    // 删除排序数组中的重复项 0 1 2 2 3 3 4
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1;j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // 每次比较前i项和后i项的和 每次包含nums[i]
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            // 前i项的和
            total += nums[i];
            //
            if (total == sum) {
                return i;
            }
            // 后i项的和
            sum = sum - nums[i];
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - preSum - nums[i] == preSum) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        // removeDuplicates(new int[]{0, 1, 2, 2, 3, 3, 4});
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
