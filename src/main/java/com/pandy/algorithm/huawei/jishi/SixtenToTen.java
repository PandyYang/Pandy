package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

/**
 * @author Pandy
 * 输入一个16进制转换为10进制
 */
public class SixtenToTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            // 参数为要解析的字符串 第二个参数为解释所使用的进制
            System.out.println(Integer.valueOf(str.substring(2), 16).toString());
        }
    }
}
