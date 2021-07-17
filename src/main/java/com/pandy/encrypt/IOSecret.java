package com.pandy.encrypt;

import java.io.*;

public class IOSecret {
    public static void main(String[] args) throws IOException {
//        secret("C:\\Users\\123\\Desktop\\123.webp");
        decrypt("C:\\Users\\123\\Desktop\\marden1.webp");
    }

    //加密
    public static void secret(String str) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(str));
        String[] s = str.split("\\.");
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("C:\\Users\\123\\Desktop\\marden1." + s[1]));
        int n;
        long a = System.currentTimeMillis();
        while ((n = bis.read()) != -1) {
            bos.write(n + 1);
        }
        long b = System.currentTimeMillis();
        bis.close();
        bos.close();
        System.out.println("加密拷贝成功！");
        System.out.println("加密用时：" + (b - a) + "ms");
    }


    //解密
    public static void decrypt(String str) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(str));
        String[] s = str.split("\\.");
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("C:\\Users\\123\\Desktop\\marden2." + s[1]));
        int n;
        long a = System.currentTimeMillis();
        while ((n = bis.read()) != -1) {
            bos.write(n - 1);
        }
        long b = System.currentTimeMillis();
        bis.close();
        bos.close();
        System.out.println("解密拷贝成功！");
        System.out.println("解密用时：" + (b - a) + "ms");
    }
}
