package com.pandy.util.randomCode;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratorSecret {
    public static void main(String[] args) {
        String s = RandomStringUtils.randomAlphanumeric(20);
        System.out.println(s);


    }


}
