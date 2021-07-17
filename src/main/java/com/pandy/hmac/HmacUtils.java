package com.pandy.hmac;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HmacUtils {

    private Mac mac;

    /**
     * @param key 密钥，类型为字节数组
     * @param algorithm 加密的方式
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public HmacUtils(byte[] key, Algorithm algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(key, algorithm.getValue());
        // 生成一个指定 Mac 算法 的 Mac 对象
        mac = Mac.getInstance(secretKey.getAlgorithm());
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);
    }

    // 完成mac操作
    public byte[] sign(byte[] content) {
        return mac.doFinal(content);
    }

    public boolean verify(byte[] signature, byte[] content) {
        byte[] result = mac.doFinal(content);
        return Arrays.equals(signature, result);
    }

    public static enum Algorithm {

        HMAC_MD5("HmacMD5"),
        HMAC_SHA1("HmacSHA1"),
        HMAC_SHA256("HmacSHA256"),
        HMAC_SHA384("HmacSHA384"),
        HMAC_SHA512("HmacSHA512");

        private String value;

        Algorithm(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
