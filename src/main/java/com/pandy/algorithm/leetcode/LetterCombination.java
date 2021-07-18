package com.pandy.algorithm.leetcode;

import java.util.*;

/**
 * @Author Pandy
 * @Date 2021/7/18 12:10
 * 电话号码的组合
 * 回溯法
 */
public class LetterCombination {
    int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};
    // 映射
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // 结果集
    StringBuilder sb = new StringBuilder();

    List<String> res= new ArrayList<>();

    public List<String> combinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        backTrace(digits, 0);
        return res;
    }

    private void backTrace(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = letters[digits.charAt(index) - '2'];
        for (char c : val.toCharArray()) {
            sb.append(c);
            backTrace(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.combinations("23"));
    }
}
