package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

// < 2  -1
// 2n+1 1
// 4n   3
// other 4
public class YangHui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n <= 2)
                System.out.println(-1);
            else if (n % 2 == 1) {
                System.out.println(2);
            } else {
                if (n % 4 == 0)
                    System.out.println(3);
                else
                    System.out.println(4);
            }
        }
        in.close();
    }

    /**
     * 对4取余  1 3 -> 2;  0 -> 3; 2 -> 4;
     * public static void main(String[] args) {
     *         Scanner in = new Scanner(System.in);
     *         while (in.hasNextInt()) {
     *             int num = in.nextInt();
     *             if(num == 1 || num == 2){
     *                 System.out.println(-1);
     *                 continue;
     *             }
     *             else if(num % 4 == 1 || num % 4 == 3){
     *                 System.out.println(2);
     *                 continue;
     *             }
     *             else if(num % 4 == 0){
     *                 System.out.println(3);
     *                 continue;
     *             }
     *             else if(num % 4 == 2){
     *                 System.out.println(4);
     *                 continue;
     *             }
     *         }
     *     }
     */
}
