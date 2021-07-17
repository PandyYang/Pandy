package com.pandy.algorithm.huawei.jishi;

import java.util.Scanner;

public class SimplePassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'Z') {
                    stringBuilder.append('a');
                    continue;
                }
                if (chars[i] >= 'A' && chars[i] < 'Z') {
                    stringBuilder.append(String.valueOf((char)(chars[i] +1)).toLowerCase());
                    continue;
                }
                if (chars[i] >= '0' && chars[i] <= '9') {
                    stringBuilder.append(String.valueOf(chars[i]));
                }
                switch (chars[i]) {
                    case('1'):
                        break;
                    case('a'):
                    case ('b'):
                    case ('c'):
                        stringBuilder.append('2');
                        break;
                    case ('d'):
                    case ('e'):
                    case ('f'):
                        stringBuilder.append('3');
                        break;
                    case ('g'):
                    case ('h'):
                    case ('i'):
                        stringBuilder.append('4');
                        break;
                    case ('j'):
                    case ('k'):
                    case ('l'):
                        stringBuilder.append('5');
                        break;
                    case ('m'):
                    case ('n'):
                    case ('o'):
                        stringBuilder.append('6');
                        break;
                    case ('p'):
                    case ('q'):
                    case ('r'):
                    case ('s'):
                        stringBuilder.append('7');
                        break;
                    case ('t'):
                    case ('u'):
                    case ('v'):
                        stringBuilder.append('8');
                        break;
                    case ('w'):
                    case ('x'):
                    case ('y'):
                    case ('z'):
                        stringBuilder.append('9');
                        break;
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
