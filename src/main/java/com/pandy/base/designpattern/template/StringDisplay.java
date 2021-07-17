package com.pandy.base.designpattern.template;

import java.nio.charset.StandardCharsets;

/**
 * @author Pandy
 * @date 2021/3/5 16:24
 */
public class StringDisplay extends AbstractDisplay{

    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes(StandardCharsets.UTF_8).length;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    public void printLine() {
        System.out.println("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
