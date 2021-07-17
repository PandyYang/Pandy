package com.pandy.algorithm.geek.reverselist;

/**
 * @author Pandy
 */
public class SqrtX {
    public static int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while (r >= l) {
            int mid = l + (r - l)/2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return index;
    }

    public static int newton(int x) {
        if (x == 0) {
            return -1;
        }
        return (int) sqrt(x, x);
    }

    public static double sqrt(double i, int x) {
        double res = (i + x/i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(24));
    }
}
