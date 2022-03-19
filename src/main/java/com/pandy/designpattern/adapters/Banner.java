package com.pandy.designpattern.adapters;

/**
 * @author Pandy
 * @date 2021/3/5 15:52
 */
public class Banner {
    private String string;
    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
