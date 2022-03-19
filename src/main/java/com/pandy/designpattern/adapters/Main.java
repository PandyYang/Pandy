package com.pandy.designpattern.adapters;

/**
 * @author Pandy
 * @date 2021/3/5 15:57
 */
public class Main {
    public static void main(String[] args) {
        // 向上转型
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
