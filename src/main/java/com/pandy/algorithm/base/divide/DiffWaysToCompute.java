package com.pandy.algorithm.base.divide;

import java.util.ArrayList;
import java.util.List;

// 加括号的位置 各种组合得出的值
public class DiffWaysToCompute {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> cow = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int i1 : left) {
                    for (int i2 : right) {
                        switch (c) {
                            case '+':
                                cow.add(i1 + i2);
                                break;
                            case '-':
                                cow.add(i1 - i2);
                                break;
                            case '*':
                                cow.add(i1 * i2);
                                break;
                        }
                    }
                }
            }
        }
        if (cow.size() == 0) {
            cow.add(Integer.valueOf(input));
        }
        return cow;
    }

    public static void main(String[] args) {
        List<Integer> integers = diffWaysToCompute("2-1-1");
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
    }
}
