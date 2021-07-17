package com.pandy.base.designpattern.template;

/**
 * @author Pandy
 * @date 2021/3/5 16:14
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
