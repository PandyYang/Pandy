package com.pandy.algorithm.offer.question;

public class Solution {
    public double Power(double base, int exponent) {
        int res = 0;
        if (base == 0 && exponent > 0) return 0;
        if (exponent == 0 && base != 0) return 1;
        if (exponent > 0) {
            res = (int) mul(base, exponent);
        }

        if (exponent < 0) {
            res = (int) mul(1 / base, -exponent);
        }
        return res;
    }

    private double mul(double base, int exponent) {
        double res = 1;
        for (int i = 0; i < exponent; i++) {
            res = base * res;
        }
        return res;
    }
}