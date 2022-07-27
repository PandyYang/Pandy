package com.pandy.algorithm.huawei.jishi;

import java.util.Arrays;
import java.util.Scanner;

public class BeautyLevel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                calculate(sc.next());
            }
        }
        sc.close();
    }

    public static void calculate(String input) {
        int[] num_ch = new int[26];
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'a':
                    num_ch[0]++;
                    break;
                case 'b':
                    num_ch[1]++;
                    break;
                case 'c':
                    num_ch[2]++;
                    break;
                case 'd':
                    num_ch[3]++;
                    break;
                case 'e':
                    num_ch[4]++;
                    break;
                case 'f':
                    num_ch[5]++;
                    break;
                case 'g':
                    num_ch[6]++;
                    break;
                case 'h':
                    num_ch[7]++;
                    break;
                case 'i':
                    num_ch[8]++;
                    break;
                case 'j':
                    num_ch[9]++;
                    break;
                case 'k':
                    num_ch[10]++;
                    break;
                case 'l':
                    num_ch[11]++;
                    break;
                case 'm':
                    num_ch[12]++;
                    break;
                case 'n':
                    num_ch[13]++;
                    break;
                case 'o':
                    num_ch[14]++;
                    break;
                case 'p':
                    num_ch[15]++;
                    break;
                case 'q':
                    num_ch[16]++;
                    break;
                case 'r':
                    num_ch[17]++;
                    break;
                case 's':
                    num_ch[18]++;
                    break;
                case 't':
                    num_ch[19]++;
                    break;
                case 'u':
                    num_ch[20]++;
                    break;
                case 'v':
                    num_ch[21]++;
                    break;
                case 'w':
                    num_ch[22]++;
                    break;
                case 'x':
                    num_ch[23]++;
                    break;
                case 'y':
                    num_ch[24]++;
                    break;
                case 'z':
                    num_ch[25]++;
                    break;
                case 'A':
                    num_ch[0]++;
                    break;
                case 'B':
                    num_ch[1]++;
                    break;
                case 'C':
                    num_ch[2]++;
                    break;
                case 'D':
                    num_ch[3]++;
                    break;
                case 'E':
                    num_ch[4]++;
                    break;
                case 'F':
                    num_ch[5]++;
                    break;
                case 'G':
                    num_ch[6]++;
                    break;
                case 'H':
                    num_ch[7]++;
                    break;
                case 'I':
                    num_ch[8]++;
                    break;
                case 'J':
                    num_ch[9]++;
                    break;
                case 'K':
                    num_ch[10]++;
                    break;
                case 'L':
                    num_ch[11]++;
                    break;
                case 'M':
                    num_ch[12]++;
                    break;
                case 'N':
                    num_ch[13]++;
                    break;
                case 'O':
                    num_ch[14]++;
                    break;
                case 'P':
                    num_ch[15]++;
                    break;
                case 'Q':
                    num_ch[16]++;
                    break;
                case 'R':
                    num_ch[17]++;
                    break;
                case 'S':
                    num_ch[18]++;
                    break;
                case 'T':
                    num_ch[19]++;
                    break;
                case 'U':
                    num_ch[20]++;
                    break;
                case 'V':
                    num_ch[21]++;
                    break;
                case 'W':
                    num_ch[22]++;
                    break;
                case 'X':
                    num_ch[23]++;
                    break;
                case 'Y':
                    num_ch[24]++;
                    break;
                case 'Z':
                    num_ch[25]++;
                    break;
            }
        }
        Arrays.sort(num_ch);
        int result = 0;
        for (int i = 1; i <= 26; i++) {
            result += i * num_ch[i - 1];
        }
        System.out.println(result);
    }
}
