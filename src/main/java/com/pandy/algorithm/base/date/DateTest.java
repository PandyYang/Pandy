package com.pandy.algorithm.base.date;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis() + ((long) 60 * 60 * 24 * 1000 * 30)));
    }
}
