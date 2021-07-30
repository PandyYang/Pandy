package com.pandy.algorithm.greedy;

import java.util.Arrays;

/**
 * @Author Pandy
 * @Date 2021/7/28 22:07
 */
public class FindContentChildren {
    public int find(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si ++;
        }
        return gi;
    }
}
