package com.pandy.java.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacTest2 {

    private static Mac mac;

    //得到密钥 发送方和接收方 使用一个密钥
    public static byte[] getSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5"); // 可填入 HmacSHA1，HmacSHA256 等
        SecretKey key = keyGenerator.generateKey();

        byte[] keyBytes = key.getEncoded();
        return keyBytes;
    }

    /**
     * 加密Hmac 生成定长的消息摘要 发送端
     *
     * @param key
     * @param data
     * @return 加密之后的16禁止的
     * @throws Exception
     */
    public static String encryptHmac(byte[] key, byte[] data) throws Exception {
        // 指定密钥
        //byte[] key = "123456".getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");

        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);

        byte[] resultBytes = mac.doFinal(data);
        String resultString = bytesToHexString(resultBytes);

        return resultString;
    }

    /**
     * 接收端
     */
    public static String receiver(byte[] key, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException {
        // 根据密钥和加密类型 初始化一个mac对象
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
        // 生成一个指定 Mac 算法 的 Mac 对象
        mac = Mac.getInstance(secretKey.getAlgorithm());
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);
        // 完成mac操作
        byte[] signResult = mac.doFinal(data);
        return bytesToHexString(signResult);
    }


    /**
     * byte数组转换为16进制
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(encryptHmac(getSecretKey(), "HelloWord".getBytes(StandardCharsets.UTF_8)));
        String content = "content";

        //模拟客户端发送
        String send = encryptHmac("password".getBytes(StandardCharsets.UTF_8), content.getBytes(StandardCharsets.UTF_8));

        //模拟服务端接收
        String receive = receiver("password".getBytes(StandardCharsets.UTF_8), "content1".getBytes(StandardCharsets.UTF_8));

        System.out.println(send.equals(receive));
    }
}
