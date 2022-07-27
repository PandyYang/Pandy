package com.pandy.algorithm.offer.question;

public class Pow {
    public double power(double bash, int exponent) {
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res *= bash;
        }
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }
}
