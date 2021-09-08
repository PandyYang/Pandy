package com.pandy.test;


/**
 * 写一个函数，在屏幕上输出一个由星号和空格组成的倒立的三角形。函数的返回值为空，参数为正整数n。如下
 * void Print(int n)
 * {
 * }
 * 例如，当n等于3的时候，屏幕上的输出如下
 * * * *
 * * *
 * *
 * 当n等于4的时候，屏幕上的输入如下
 * * * * *
 * * * *
 * * *
 * *
 */
public class Test {
    public static void main(String[] args) {
        print(4);
    }

    static void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = n; j >= i; j--) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
