package com.pandy.algorithm;

/**
 * @author Pandy
 */
public class AppleDemo {
    public static int solve(int m, int n) {
        if (n == 1 || m ==1 || m == 0){
            return 1;
        }
        if (m < n) {
            return solve(m, n);
        }else {
            return solve(m, n-1) + solve(m-n, n);
        }
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        System.out.println(solve(m, n));
    }
}
