package com.pandy.algorithm.offer.question;

public class NumOf1 {
    public static int numOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
}
