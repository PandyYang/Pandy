package com.pandy.algorithm.leetcode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pandy
 * 回溯算法解决字母的组合
 */
public class LetterCombine {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();
    String digits;
    char[][] ch = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
//        System.out.println(new LetterCombine().letterCombinations("23"));
        System.out.println(new LetterCombine().permute(new int[]{1, 2, 3}));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        this.digits = digits;
        backTrack(0);
        return res;
    }

    public void backTrack(int length) {
        if (track.length() == digits.length()) {
            res.add(String.valueOf(track));
            return;
        }

        for (int i = length; i < digits.length(); i++) {
            for (int j = 0; j < ch[digits.charAt(i) - '2'].length; j++) {
                track.append(ch[digits.charAt(i) - '2'][j]);
                backTrack(i + 1);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backTrack(n, output, res, 0);
        return res;
    }

    public void backTrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) { // 0 1 2
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backTrack(n, output, res, first + 1); // first = 1  first = 2
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
