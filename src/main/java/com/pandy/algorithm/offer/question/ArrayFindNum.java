package com.pandy.algorithm.offer.question;


public class ArrayFindNum {
    public static boolean isExist(int[][] arr, int target) {
        int len = arr[0].length;
        int row = arr.length;
        int i = 0;
        int j = row - 1;
        while (i <= len - 1 && j >= 0) {
            if (arr[i][j] == target) {
                return true;
            }
            if (arr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(isExist(arr, 11));
    }
}
