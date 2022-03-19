package com.pandy.designpattern.adapters;

/**
 * @author Pandy
 * @date 2021/3/5 15:56
 */
public class PrintBanner extends Banner implements Print{

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
