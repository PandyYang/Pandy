package com.pandy.algorithm.offer.question;

public class Power {
    public double power(double base, int exponent) {
        double res = 0;
        if (equal(base, 0)) {
            return 0;
        }

        if (exponent > 0) {
            res = mutiply(base, exponent);
        } else {
            res = mutiply(1/base, -exponent);
        }
        return res;
    }

    public double mutiply(double base, int e) {
        double sum = 1;
        for (int i = 0; i < e; i++) {
            sum = sum * base;
        }
        return sum;
    }

    public boolean equal(double a, double b) {
        return (a - b < 0.000001 && a - b > -0.000001);
    }
}
