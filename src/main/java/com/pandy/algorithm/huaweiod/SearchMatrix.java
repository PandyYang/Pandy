package com.pandy.algorithm.huaweiod;

import java.util.Scanner;

public class SearchMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int[][] res = new int[num][];
            int maxSide = 0;
            for (int i = 0; i < num; i++) {
                String next = in.next();
                res[i] = new int[next.length()];
                for (int i1 = 0; i1 < next.length(); i1++) {
                    res[i][i1] = Integer.parseInt(String.valueOf(next.charAt(i1)));
                }
            }
            int height = res.length;
            int width = res[0].length;
            int[][] dp = new int[height + 1][width + 1];

            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (res[row][col] == 1) {
                        dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                        maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                    }
                }
            }
            System.out.println(maxSide * maxSide);
        }
    }
}
