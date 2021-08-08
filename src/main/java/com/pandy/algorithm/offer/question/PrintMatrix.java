package com.pandy.algorithm.offer.question;

import java.util.ArrayList;

/**
 * 矩阵的遍历
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix)  {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {

            // 最上面一行
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }

            // 向下移动
            up++;
            // 超出底线 直接跳出
            if (up > down) break;

            // 最右边一行
            for (int row = up; row <= down; row ++) {
                list.add(matrix[row][right]);
            }

            // 向左移动
            right--;
            if (left > right) {
                break;
            }

            // 下面一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }

            down--;
            if (up > down) break;

            // 最左边一行
            for (int row =down; row >= up; row--) {
                list.add(matrix[row][left]);
            }

            left++;
            if (left > right) break;
        }
        return list;
    }
}
