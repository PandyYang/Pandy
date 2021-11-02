package com.pandy.test;

import java.util.Random;
import java.util.UUID;

public class GenerateRandomKey {
    public static void main(String[] args) {
        String randomString = usingUUID();
        System.out.println("Random string is: " + randomString);
        System.out.println("Random string of 8 characters is: "
                + randomString.substring(0, 10));
    }

    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }
}
