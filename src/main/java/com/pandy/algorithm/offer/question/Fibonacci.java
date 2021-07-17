package com.pandy.algorithm.offer.question;

/**
 * 找出斐波那契数列的n项
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(test(10));
    }

    public static long test(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        if (n == 0) {
            return preTwo;
        }

        if (n == 1) {
            return preOne;
        }

        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
