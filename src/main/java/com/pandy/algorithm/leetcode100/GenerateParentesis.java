package com.pandy.algorithm.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Pandy
 * @Date 2021/7/18 16:59
 * 深度优先遍历和回溯算法 解决括号组合问题
 */
public class GenerateParentesis {

    private final List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParentesis generateParentesis = new GenerateParentesis();
        System.out.println(generateParentesis.generate(2));
    }

    public List<String> generate(int n) {
        dfs("", n, 0, 0);
        return res;
    }

    public void dfs(String ans, int n, int open, int close) {
        //剪枝策略 一旦比括号大于开括号的数量 直接回溯 或者 开括号的数量大于n
        if (close > open || open > n) return;
        // 当左右括号 数目和n相同 则为有效组合
        if (open == n && open == close) res.add(ans);
        dfs(ans + '(', n, open + 1, close);
        dfs(ans + ')', n, open, close + 1);
    }
}
