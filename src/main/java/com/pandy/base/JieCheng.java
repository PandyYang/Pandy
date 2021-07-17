package com.pandy.base;

import java.math.BigInteger;

public class JieCheng {
    public static void main(String[] args) {

        BigInteger A =  new BigInteger(String.valueOf(1));
        BigInteger B =  new BigInteger(String.valueOf(1));
        for(int i = 10000;i >= 1; i--) {
            B = B.multiply(A);
            A = A.add(BigInteger.valueOf(1));
        }
        System.out.println(B);
    }
}
