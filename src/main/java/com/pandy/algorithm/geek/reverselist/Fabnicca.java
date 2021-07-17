package com.pandy.algorithm.geek.reverselist;

/**
 * @author Pandy
 * 求斐波那契数列
 */
public class Fabnicca {
    public static int calculate(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return calculate(num - 1) + calculate(num - 2);
    }
}
