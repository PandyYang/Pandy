package com.pandy.java.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class GenerateKey {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5"); // 可填入 HmacSHA1，HmacSHA256 等
        SecretKey key = keyGenerator.generateKey();
        byte[] keyBytes = key.getEncoded();
        String res = HmacTest2.bytesToHexString(keyBytes);
        System.out.println(res);
    }
}
