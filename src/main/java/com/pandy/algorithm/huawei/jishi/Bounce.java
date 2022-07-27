package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

/**
 * 小球落地5次之后经历的路程和第5次反弹的高度
 */
public class Bounce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double i = scanner.nextInt();
            double high = i;
            for (int j = 0; j < 4; j++) {
                high += i;
                i = i / 2.0;
            }
            i = i / 2.0;
            System.out.println(high);
            System.out.println(i);
        }
    }
}
