package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

/**
 * @author Pandy
 */
public class PrimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long data = sc.nextLong();
        for (int i = 2; i <= Math.sqrt(data); i++) {
            while (data % i == 0) {
                System.out.println(i + " ");
                data = data / i;
            }
        }
        if (data != 1) {
            System.out.print(data + " ");
        }
    }
}
