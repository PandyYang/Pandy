package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class SplitStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        int num;

        while (in.hasNext()) {
            str = in.next();
            num = in.nextInt();
            char[] arr = str.toCharArray();
            int temp = 0;
            int i = 0;
            // 小于字符数量
            while (temp < num) {
                // 判断是中文
                if (arr[i] > 128) {
                    temp += 2;
                    // 截取字符长度+1
                    if (temp <= num)
                        i++;
                } else {
                    temp++;
                    if (temp <= num)
                        i++;
                }
            }
            System.out.println(str.substring(0, i));

        }

        in.close();
    }
}
