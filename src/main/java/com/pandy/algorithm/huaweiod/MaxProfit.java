package com.pandy.algorithm.huaweiod;

import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] s = in.nextLine().split(" ");
            int[] trans = trans(s);
            int[] change = new int[trans.length];
            int maxProfit = 0;
            for (int i = 1; i < trans.length; i++)
            {
                change[i] = trans[i] - trans[i - 1];
                if (change[i] > 0)
                {
                    maxProfit += change[i];
                }
            }
            System.out.println(maxProfit);
        }
    }

    public static int[] trans(String[] res) {
        int[] aaa = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            if (res[i].endsWith("Y")) {
                aaa[i] = Integer.parseInt(res[i].substring(0, res[i].length() - 1));
            } else {
                aaa[i] = 7 * Integer.parseInt(res[i].substring(0, res[i].length() - 1));
            }
        }
        return aaa;
    }
}


//class Solution {
//    public int maxProfit(int[] prices) {
//        int cost = Integer.MAX_VALUE, profit = 0;
//        for(int price : prices) {
//            cost = Math.min(cost, price);
//            profit = Math.max(profit, price - cost);
//        }
//        return profit;
//    }
//}

