package com.pandy.designpattern.template;

/**
 * @author Pandy
 * @date 2021/3/5 16:28
 */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay a1 = new CharDisplay('H');
        AbstractDisplay a2 = new StringDisplay("Hello World");
        a1.display();
        a2.display();
    }
}
